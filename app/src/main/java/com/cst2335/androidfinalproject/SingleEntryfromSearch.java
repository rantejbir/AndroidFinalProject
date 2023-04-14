package com.cst2335.androidfinalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.CollapsingToolbarLayout;

/**
 * Author: Daksh Sharma
 * Date updated: 8/4/2023
 * purpose: This class represents a function that allows a user to view a single entry's information and
 * add it to their list. This class's function is to manage
 * the screen's UI and communicate with the underlying database so that a user may be added to the list.
 */
public class SingleEntryfromSearch extends AppCompatActivity {
    String name = " ";
    String category = " ";
    String others = " ";
    ListDao mDAO;


    ListEntry n = new ListEntry();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);

        ListDatabase db = ListDatabase.getInstance(this);
        mDAO = db.listDao();

        getSupportActionBar().hide();
        name = getIntent().getExtras().getString("name");
        category = getIntent().getExtras().getString("category");
        others = getIntent().getExtras().getString("others");


        @SuppressLint("WrongViewCast")
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name = findViewById(R.id.aa_anime_name);
        TextView tv_categorie = findViewById(R.id.aa_categorie);
        TextView tv_rating = findViewById(R.id.aa_rating);

        tv_name.setText(name);
        tv_categorie.setText(category);
        tv_rating.setText(others);

        collapsingToolbarLayout.setTitle(name);


        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading).error(R.drawable.loading);

        n = new ListEntry(name, category, others);
        // set image using Glide
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(clk -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(SingleEntryfromSearch.this);
            builder.setMessage("Do you want to Add the item to your List: " + n.getName())
                    .setTitle(R.string.popup)
                    .setNegativeButton(R.string.no, (dialog, cl) -> {
                        Toast.makeText(this, R.string.toast_message2, Toast.LENGTH_LONG).show();
                    })
                    .setPositiveButton(R.string.yes, (dialog, cl) -> {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                mDAO.insertEntry(n);
                            }
                        }).start();

                        Intent i = new Intent(SingleEntryfromSearch.this, MyListFromDB.class);
                        i.putExtra("AddYes", "yes");
                        startActivity(i);
                    })
                    .create().show();

        });


    }


}