package com.cst2335.androidfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.cst2335.androidfinalproject.ui.login.AddNewFragment;
import com.cst2335.androidfinalproject.ui.login.searchFragment;

/**
 * @author Rantejbir Singh
 * A Java class that symbolises an Android application's main function is this one.
 * the com.cst2335.androidfinalproject package.
 * The activity builds on the Android framework's AppCompatActivity class.
 * When the activity begins, the search_more_Fragment2 is loaded into the fragment_container and will by default be visible. When the user clicks on the
 * respective buttons on the other three fragments, HomeFragment, AddNewFragment, and searchFragment, the fragment_container is loaded.
 */
public class MainActivity2 extends AppCompatActivity {
    /**
     * Set the layout for the activity using setContentView(R.layout.activity_main4) in the onCreate() method, w
     * hich enlarges the activity_main4 layout file.
     *
     * Three ImageButton views are created by the code, and click listeners are added to each of them. When a button is clicked, a fragment transaction is
     * used to load the associated fragment into the activity's fragment_container layout element.
     * @param savedInstanceState
     */
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
            AddNewFragment homeFragment1 = new AddNewFragment();

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