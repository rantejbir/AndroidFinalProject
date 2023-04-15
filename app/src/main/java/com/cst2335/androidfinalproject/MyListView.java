package com.cst2335.androidfinalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.List;

/**
 * @author Rantejbir Singh
 * Using Room, an Android library for working with databases, the activity obtains the item's data from a SQLite database.
 * A DAO (Data Access Object) called ListDao is used to access the database. By using ListDatabase to obtain an instance of the database,
 * the activity creates the DAO.getInstance(this).
 *
 * The activity creates the UI components by using findViewById() to locate the pertinent views in the layout XML file, and then setting their text values with the item data. Additionally, it uses CollapsingToolbarLayout.setTitle() to set the title of the app bar. When a user clicks the delete button, a warning dialogue appears asking them to confirm that they really do want to delete the item.
 * If the user agrees to the deletion, ListDao is used to remove the item from the database.DeleteEntry(),
 */
public class MyListView extends AppCompatActivity {
    String name=" ";
    String category=" ";
    String others=" ";
    int id;
    ListDao mDAO;
    List<ListEntry> nww;



    ListEntry n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list3);

        ListDatabase db = ListDatabase.getInstance(this);
        mDAO = db.listDao();

        getSupportActionBar().hide();
        name = getIntent().getExtras().getString("name");
        category = getIntent().getExtras().getString("category");
        others = getIntent().getExtras().getString("others");
        id = getIntent().getExtras().getInt("id");



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



        new Thread(new Runnable() {
            @Override
            public void run() {
                n = mDAO.getById(id);
            }
        }).start();

        Button btn=findViewById(R.id.button);

        btn.setOnClickListener(clk -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MyListView.this);
            builder.setMessage("Do you want to delete the item from List: " + n.getName())
                    .setTitle(R.string.popup)
                    .setNegativeButton(R.string.no, (dialog, cl) -> {
                        Toast.makeText(this, R.string.toast_message_del_no, Toast.LENGTH_LONG).show();
                    })
                    .setPositiveButton(R.string.yes, (dialog, cl) -> {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                mDAO.DeleteEntry(n);
                            }
                        }).start();
                        Intent i = new Intent(MyListView.this, MyListFromDB.class);
                        i.putExtra("delOrNo","yes");
                        startActivity(i);
                    })
                    .create().show();

        });



    }


}