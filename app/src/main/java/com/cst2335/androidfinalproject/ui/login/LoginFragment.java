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

import com.cst2335.androidfinalproject.LoginMyList;
import com.cst2335.androidfinalproject.MainActivity;
import com.cst2335.androidfinalproject.MyListFromDB;
import com.cst2335.androidfinalproject.R;

public class LoginFragment extends Fragment {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    public static final String SHARED = "sharedPrefs";
    public String user = "user";
    public String pass = "pass";


    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.login_fragment, container, false);

        emailEditText = view.findViewById(R.id.emailEditText);
        passwordEditText = view.findViewById(R.id.passwordEditText);
        loginButton = view.findViewById(R.id.loginButton);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String usern = sharedPreferences.getString(user, "");
        String passn = sharedPreferences.getString(pass, "");
        emailEditText.setText(usern);
        passwordEditText.setText(passn);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                editor.putString(user,email);
                editor.putString(pass,password);
                editor.apply();
                Intent i = new Intent(getActivity(), MyListFromDB.class);
//
            startActivity(i);
            }
        });

        return view;
    }
}
