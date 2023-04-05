package com.cst2335.androidfinalproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

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
//        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
//        Button loginButton=findViewById(R.id.loginButton);
//        loginButton.setOnClickListener(clk -> {
//            Intent i = new Intent(LoginMyList.this, MyListFromDB.class);
//
//            startActivity(i);
//        });
    }
}
