package com.cst2335.androidfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rantejbir Singh
 * The activity builds on the Android framework's AppCompatActivity class.
 * Set the activity's layout by inflating the activity_main layout file with setContentView(R.layout.activity_main).
 *
 * Two buttons are created by the code, and click listeners are attached to them. When a button is clicked, an intent to start
 * a different activity is established.
 */
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
//        Intent in = getIntent();
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button btn3 = findViewById(R.id.MyList);
        btn3.setOnClickListener(clk -> {

            Intent in = new Intent(MyListFromDB.this, HomePage.class);

            startActivity(in);
        });
        Button btn4 = findViewById(R.id.more);
        btn4.setOnClickListener(clk -> {

            Intent in = new Intent(MyListFromDB.this, MainActivity2.class);
            startActivity(in);
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                newEntry.addAll((mDAO.getAllEntries()));

            }
            /**
             * Finally, there are a few conditional statements that check whether the user has recently added or deleted an item from the list,
             * and display a corresponding message using a Toast if necessary.
             */
        }).start();
        Intent ini=getIntent();
        if((ini.getStringExtra("delOrNo"))!=null){
            n = ini.getStringExtra("delOrNo");
            if(n.equals("yes")){
                Toast.makeText(this, R.string.toast_message_del_yes, Toast.LENGTH_LONG).show();
            }
        }else if((ini.getStringExtra("AddYes"))!=null){
            Toast.makeText(this, R.string.toast_message, Toast.LENGTH_LONG).show();

        }



        recyclerView = findViewById(R.id.recyclerviewid);
        setuprecyclerview(newEntry);
    }

    /**
     * To obtain an instance of the ListDao, use the singleton class known as ListDatabase. The database's whole entry list is then retrieved using the ListDao. To prevent obstructing the main UI thread, this is done in a separate thread.
     *
     * The list of entries that was obtained is then sent to the setuprecyclerview() method, which creates a RecyclerView and adds an adapter to it. RecyclerViewAdapter2, a unique adapter that extends the RecyclerView, is the type of adapter
     * that makes up the adapter.adapter type.
     * @param lstAnime
     */
    private void setuprecyclerview(List<ListEntry> lstAnime) {



        RecyclerViewAdapter2 myadapter = new RecyclerViewAdapter2(this,newEntry) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);

    }
}