package com.cst2335.androidfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class MainActivity2 extends AppCompatActivity {
    private List<ListEntry> newEntry=new ArrayList<>();
    private ListDao mDAO;
    private RecyclerView recyclerView ;



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

//
        recyclerView = findViewById(R.id.recyclerviewid);
        setuprecyclerview(newEntry);
    }


    private void setuprecyclerview(List<ListEntry> lstAnime) {



        RecyclerViewAdapter2 myadapter = new RecyclerViewAdapter2(this,newEntry) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);

    }
}