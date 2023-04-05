package com.cst2335.androidfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    //    private String JSON_URL="https://www.thecocktaildb.com/api/json/v1/1/search.php?s=mojito";
    private final String JSON_URL = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json" ;
    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    private List<ListEntry> newEntry;
    private ListDao mDAO;
    private RecyclerView recyclerView ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newEntry = new ArrayList<>() ;
        recyclerView = findViewById(R.id.recyclerviewid);
        jsonrequest();
//        ListDatabase db = ListDatabase.getInstance(this);
//        mDAO = db.listDao();



        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button btn3=findViewById(R.id.MyList);
        btn3.setOnClickListener(clk -> {
            Intent i = new Intent(MainActivity.this, LoginMyList.class);

            startActivity(i);
        });
    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject =null;

//
                for (int i = 0; i < response.length(); i++) {


                    try {
                        jsonObject = response.getJSONObject(i) ;
                        ListEntry addNew = new ListEntry() ;

                        addNew.setName(jsonObject.getString("name"));

                        addNew.setCategory(jsonObject.getString("categorie"));
                        addNew.setOther(jsonObject.getString("episode"));

                        newEntry.add(addNew);



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                setuprecyclerview(newEntry);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request) ;


    }

    private void setuprecyclerview(List<ListEntry> lstAnime) {


        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,newEntry) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);

    }
}