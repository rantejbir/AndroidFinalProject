package com.cst2335.androidfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;


import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;




import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

//    private String JSON_URL="https://www.thecocktaildb.com/api/json/v1/1/search.php?s=mojito";
        private final String JSON_URL = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json" ;
    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    private List<list> lstAnime ;
    private RecyclerView recyclerView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstAnime = new ArrayList<>() ;
        recyclerView = findViewById(R.id.recyclerviewid);
        jsonrequest();



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
                        list anime = new list() ;
                        anime.setName(null);
                        anime.setDescription(null);
                        anime.setRating(null);
                        anime.setCategorie(null);
                        anime.setNb_episode(0);
                        anime.setStudio(null);
                        anime.setImage_url(null);
                        lstAnime.add(anime);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                setuprecyclerview(lstAnime);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request) ;


    }

    private void setuprecyclerview(List<list> lstAnime) {


        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,lstAnime) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);

    }
}