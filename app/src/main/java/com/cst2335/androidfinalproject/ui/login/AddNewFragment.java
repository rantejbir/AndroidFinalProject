package com.cst2335.androidfinalproject.ui.login;

import static android.content.Context.MODE_PRIVATE;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.cst2335.androidfinalproject.ListDao;
import com.cst2335.androidfinalproject.ListDatabase;
import com.cst2335.androidfinalproject.ListEntry;
import com.cst2335.androidfinalproject.MyListFromDB;
import com.cst2335.androidfinalproject.MyListView;
import com.cst2335.androidfinalproject.databinding.FragmentAddNewBinding;

import com.cst2335.androidfinalproject.R;

public class AddNewFragment extends Fragment {

    private LoginViewModel loginViewModel;
    private FragmentAddNewBinding binding;
    public static final String SHARED = "sharedPrefs";
    public String nameOfDrink = "DrinkName";
    public String CategoryDrink = "CategoryOfDrink";
    public String InstructionDrink = "Instruction";
    private ListDao mDAO;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentAddNewBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);
        ListDatabase db = ListDatabase.getInstance(getActivity());
        mDAO = db.listDao();
        final EditText NameOfDrink = binding.NameOfDrink;
        final EditText category = binding.category;
        final EditText instruction = binding.instruction;
        final Button loginButton = binding.login;
        final ProgressBar loadingProgressBar = binding.loading;

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String name1 = sharedPreferences.getString(nameOfDrink, "");
        String name2 = sharedPreferences.getString(CategoryDrink, "");
        String name3 = sharedPreferences.getString(InstructionDrink, "");
        NameOfDrink.setText(name1);
        category.setText(name2);
        instruction.setText(name3);
        loginButton.setOnClickListener(clk -> {
            String name=NameOfDrink.getText().toString();
            String cat=category.getText().toString();
            String inst=instruction.getText().toString();
            editor.putString(nameOfDrink,name);
            editor.putString(CategoryDrink,cat);
            editor.putString(InstructionDrink,inst);
            editor.apply();
            ListEntry n = new ListEntry(name,cat,inst);
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Do you want to Add the item to List: " + n.getName())
                    .setTitle(R.string.popup)
                    .setNegativeButton(R.string.no, (dialog, cl) -> {
                        Toast.makeText(getActivity(), R.string.toast_message2, Toast.LENGTH_LONG).show();
                    })
                    .setPositiveButton(R.string.yes, (dialog, cl) -> {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                mDAO.insertEntry(n);
                            }
                        }).start();
                        Intent i = new Intent(getActivity(), MyListFromDB.class);
                        i.putExtra("AddYes","yes");
                        startActivity(i);
                    })
                    .create().show();

        });
    }


}