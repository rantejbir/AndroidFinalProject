package com.cst2335.androidfinalproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.cst2335.androidfinalproject.ui.login.LoginFragment;

/**
 * Author:Daksh Sharma
 * Date updated: 8/4/2023
 * purpose: This class's functions include managing the switching between several
 * parts in response to user input and designing the user experience for a login page.
 */
public class LoginMyList extends AppCompatActivity {
    /**
     * When the "help" button is pressed, a new "HomeFragment" replaces the existing fragment.
     * When the "loginDb" button is hit, the original "LoginFragment" replaces the current fragment.
     * When the "RegisterDb" button is hit, a new "registerFragment" is created in place of the existing fragment.
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        LoginFragment loginFragment = new LoginFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, loginFragment)
                .commit();
        ImageButton btn=findViewById(R.id.help);
        btn.setOnClickListener(clk -> {
            HomeFragment homeFragment1 = new HomeFragment();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, homeFragment1)
                    .commit();
        });

        Button btn2=findViewById(R.id.loginDb);
        btn2.setOnClickListener(clk -> {
            LoginFragment loginFragment1 = new LoginFragment();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, loginFragment)
                    .commit();
        });
        Button btn3=findViewById(R.id.RegisterDb);
        btn3.setOnClickListener(clk -> {
            registerFragment Fragment1 = new registerFragment();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, Fragment1)
                    .commit();
        });
    }
}
