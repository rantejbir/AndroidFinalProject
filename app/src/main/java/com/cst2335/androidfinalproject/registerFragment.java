package com.cst2335.androidfinalproject;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Author: Daksh Sharma
 * Date updated: 8/4/2023
 * purpose: This class represents a user registration process for an application.
 * This class's function is to manage the register screen's UI and keep track of the user's registration data.
 * The class has a button to start the registration process as well as two EditTexts where the user may input their email and password.
 * To make it accessible later in the program, the registration data is saved in shared preferences.
 */


public class registerFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String Parameter1;
    private String Parameter2;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    public static final String SharedPreferences = "sharedPrefs";
    public String user = "user";
    public String pass = "pass";

    public registerFragment() {
        // Required empty public constructor
    }


    public static registerFragment newInstance(String para1, String para2) {
        registerFragment registerFrag = new registerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, para1);
        args.putString(ARG_PARAM2, para2);
        registerFrag.setArguments(args);
        return registerFrag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Parameter1 = getArguments().getString(ARG_PARAM1);
            Parameter2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.register_fragment, container, false);

        emailEditText = view.findViewById(R.id.emailEditText1);
        passwordEditText = view.findViewById(R.id.passwordEditText1);
        loginButton = view.findViewById(R.id.loginButton);


        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SharedPreferences, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String usern = sharedPreferences.getString(user, "");
        String passn = sharedPreferences.getString(pass, "");

        emailEditText.setText(usern);
        passwordEditText.setText(passn);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailClick = emailEditText.getText().toString();
                String passClick = passwordEditText.getText().toString();

                editor.putString(user,emailClick);
                editor.putString(pass,passClick);
                editor.apply();
                Intent i = new Intent(getActivity(), MyListFromDB.class);

                startActivity(i);
                Toast.makeText(getActivity(), R.string.Register, Toast.LENGTH_LONG).show();

            }
        });
        return view;
    }
}