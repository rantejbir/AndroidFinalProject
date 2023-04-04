package com.cst2335.androidfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.CollapsingToolbarLayout;


public class list2 extends AppCompatActivity {



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list2);

            // hide the default actionbar
            getSupportActionBar().hide();

            // Recieve data

            String name  = getIntent().getExtras().getString("anime_name");
            String category = getIntent().getExtras().getString("anime_category");

            String others = getIntent().getExtras().getString("anime_rating") ;


            // ini views

            CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
            collapsingToolbarLayout.setTitleEnabled(true);

            TextView tv_name = findViewById(R.id.aa_anime_name);

            TextView tv_categorie = findViewById(R.id.aa_categorie) ;

            TextView tv_rating  = findViewById(R.id.aa_rating) ;


            // setting values to each view

            tv_name.setText(name);
            tv_categorie.setText(category);

            tv_rating.setText(others);


            collapsingToolbarLayout.setTitle(name);


            RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading).error(R.drawable.loading);


            // set image using Glide






        }
    }