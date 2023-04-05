package com.cst2335.androidfinalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;


public class list2 extends AppCompatActivity {
    String name=" ";
    String category=" ";
    String others=" ";
    ListDao mDAO;



    ListEntry n=new ListEntry();
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




        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name = findViewById(R.id.aa_anime_name);
        TextView tv_categorie = findViewById(R.id.aa_categorie);
        TextView tv_rating = findViewById(R.id.aa_rating);


        // setting values to each view

        tv_name.setText(name);
        tv_categorie.setText(category);
        tv_rating.setText(others);


        collapsingToolbarLayout.setTitle(name);


        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading).error(R.drawable.loading);


        n = new ListEntry(name,category,others);
        // set image using Glide
        Button btn=findViewById(R.id.button);
        btn.setOnClickListener(clk -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(list2.this);
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

                        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_LONG).show();
                    })
                    .create().show();

        });



    }


}