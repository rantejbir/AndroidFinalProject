package com.cst2335.androidfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MyListFromDB extends AppCompatActivity {
    private List<ListEntry> newEntry=new ArrayList<>();
    private ListDao mDAO;
    private RecyclerView recyclerView ;
    String n="no";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListDatabase db = ListDatabase.getInstance(this);
        mDAO = db.listDao();
        new Thread(new Runnable() {
            @Override
            public void run() {
                newEntry.addAll((mDAO.getAllEntries()));

            }
        }).start();
        Intent i=getIntent();
        if((i.getStringExtra("delOrNo"))!=null){
            n = i.getStringExtra("delOrNo");
            if(n.equals("yes")){
                Toast.makeText(this, R.string.toast_message_del_yes, Toast.LENGTH_LONG).show();
            }
        }


        recyclerView = findViewById(R.id.recyclerviewid);
        setuprecyclerview(newEntry);
    }


    private void setuprecyclerview(List<ListEntry> lstAnime) {



        RecyclerViewAdapter2 myadapter = new RecyclerViewAdapter2(this,newEntry) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);

    }
}