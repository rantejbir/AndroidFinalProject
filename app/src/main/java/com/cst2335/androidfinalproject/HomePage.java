package com.cst2335.androidfinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.cst2335.androidfinalproject.ui.login.searchFragment;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        BlankFragment homeFragment = new BlankFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, homeFragment)
                .commit();

        ImageButton btn=findViewById(R.id.helpButton);
        btn.setOnClickListener(clk -> {
            HomeFragment homeFragment1 = new HomeFragment();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, homeFragment1)
                    .commit();
        });
        ImageButton btn2=findViewById(R.id.searchButton);
        btn2.setOnClickListener(clk -> {
            searchFragment homeFragment2 = new searchFragment();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, homeFragment2)
                    .commit();
        });
        ImageButton btn3=findViewById(R.id.allList);
        btn3.setOnClickListener(clk -> {
            Intent i = new Intent(HomePage.this, LoginMyList.class);
            startActivity(i);
        });

    }
}
