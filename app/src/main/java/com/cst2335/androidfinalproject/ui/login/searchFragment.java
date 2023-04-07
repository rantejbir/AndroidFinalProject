package com.cst2335.androidfinalproject.ui.login;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.cst2335.androidfinalproject.MainActivity;
import com.cst2335.androidfinalproject.MyListFromDB;
import com.cst2335.androidfinalproject.R;

public class searchFragment extends Fragment {

    private EditText searchText;

    private Button btn;
    public static final String SHARED = "sharedPrefs";
    public String search = "text";

    public searchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        searchText = view.findViewById(R.id.username);

        btn = view.findViewById(R.id.login);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String name1 = sharedPreferences.getString(search, "");
        searchText.setText(name1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = searchText.getText().toString();
                editor.putString(search,str);
                editor.apply();
                Intent i = new Intent(getActivity(), MainActivity.class);
                i.putExtra("search",str);
                startActivity(i);
            }
        });

        return view;
    }
}
