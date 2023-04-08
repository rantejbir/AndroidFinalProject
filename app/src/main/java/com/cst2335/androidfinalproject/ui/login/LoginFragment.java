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
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.cst2335.androidfinalproject.R;
import com.cst2335.androidfinalproject.registerFragment;
/**
 * Author: Daksh Sharma
 * Date updated: 8/4/2023
 * purpose: The login feature for the app is to be implemented as part of this class. It is a fragment that shows
 * a login form with two EditText boxes for entering a password and an email address, as well as a Button to start the login process.
 * In order to establish if the login was successful or not, it additionally fetches the user credentials from SharedPreferences and compares them with the values entered.
 * The MyListFromDB activity is launched if the login is successful. The user is given the opportunity to register if they do not already have an account by replacing the
 * current fragment with the registerFragment and displaying a toast notification if the login attempt fails.
 */
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



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if((usern.equals(email))&&passn.equals(password)){
                    Intent i = new Intent(getActivity(), MyListFromDB.class);
                    startActivity(i);
                }
                else{
                    View rootView = view.findViewById(android.R.id.content);


                    int toast_login;
                    Toast.makeText(getActivity(), R.string.loginNo, Toast.LENGTH_LONG).show();
                    registerFragment Fragment1 = new registerFragment();

                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, Fragment1)
                            .commit();


                }

//

            }
        });
        return view;
    }
}
