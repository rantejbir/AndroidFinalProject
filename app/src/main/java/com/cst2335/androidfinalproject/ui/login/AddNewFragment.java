package com.cst2335.androidfinalproject.ui.login;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

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
import com.cst2335.androidfinalproject.databinding.FragmentAddNewBinding;

import com.cst2335.androidfinalproject.R;

public class AddNewFragment extends Fragment {

    private LoginViewModel loginViewModel;
    private FragmentAddNewBinding binding;
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

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=NameOfDrink.getText().toString();
                String cat=category.getText().toString();
                String inst=instruction.getText().toString();
                ListEntry n = new ListEntry(name,cat,inst);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mDAO.insertEntry(n);
                    }
                }).start();

            }
        });
    }


}