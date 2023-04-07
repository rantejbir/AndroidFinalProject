package com.cst2335.androidfinalproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.cst2335.androidfinalproject.ui.login.LoginFragment;

public class LoginMyList extends AppCompatActivity {

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
