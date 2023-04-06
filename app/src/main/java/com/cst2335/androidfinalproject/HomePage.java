package com.cst2335.androidfinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cst2335.androidfinalproject.ui.login.searchFragment;
import com.google.android.material.snackbar.Snackbar;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        HomePageImageFragment homeFragment = new HomePageImageFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, homeFragment)
                .commit();
        Toast.makeText(this, R.string.Cocktail, Toast.LENGTH_LONG).show();


        ImageButton btn=findViewById(R.id.helpButton);
        btn.setOnClickListener(clk -> {
            HomeFragment homeFragment1 = new HomeFragment();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, homeFragment1)
                    .commit();
            Toast.makeText(this, R.string.help_toast, Toast.LENGTH_LONG).show();

        });
        ImageButton btn2=findViewById(R.id.searchButton);
        btn2.setOnClickListener(clk -> {
            searchFragment homeFragment2 = new searchFragment();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, homeFragment2)
                    .commit();
            Toast.makeText(this, R.string.searchAny, Toast.LENGTH_LONG).show();

        });
        ImageButton btn3=findViewById(R.id.allList);
        btn3.setOnClickListener(clk -> {
            Intent i = new Intent(HomePage.this, LoginMyList.class);
            startActivity(i);
        });

    }
}
