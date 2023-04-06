package com.cst2335.androidfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.cst2335.androidfinalproject.ui.login.AddNewFragment;
import com.cst2335.androidfinalproject.ui.login.searchFragment;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        search_more_Fragment2 homeFragment2 = new search_more_Fragment2();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, homeFragment2)
                .commit();
        ImageButton btn=findViewById(R.id.helpButton);
        btn.setOnClickListener(clk -> {
            HomeFragment homeFragment1 = new HomeFragment();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, homeFragment1)
                    .commit();
        });
        ImageButton btn5=findViewById(R.id.Addnew);
        btn5.setOnClickListener(clk -> {
            AddNewFragment homeFragment1 = new AddNewFragent();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, homeFragment1)
                    .commit();
        });
        ImageButton btn2=findViewById(R.id.searchButton);
        btn2.setOnClickListener(clk -> {
            searchFragment homeFragment3 = new searchFragment();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, homeFragment3)
                    .commit();
        });
    }
}