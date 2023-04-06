package com.cst2335.androidfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    String URL="https://www.thecocktaildb.com/api/json/v1/1/search.php?s=";

    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    private List<ListEntry> newEntry;
    private ListDao mDAO;
    private RecyclerView recyclerView ;
    protected RequestQueue queue = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newEntry = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerviewid);
        queue = Volley.newRequestQueue(this);
        Intent intent = getIntent();
        String search = intent.getStringExtra("search");
        search=search.trim();
        String JSON_URL=URL+search+"&appid=1";

        Toast.makeText(this, search, Toast.LENGTH_LONG).show();

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button btn3 = findViewById(R.id.MyList);
        btn3.setOnClickListener(clk -> {
            Intent i = new Intent(MainActivity.this, HomePage.class);

            startActivity(i);
        });
        Button btn4 = findViewById(R.id.more);
        btn4.setOnClickListener(clk -> {
            Intent i = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(i);
        });
        try {
            //this goes in the button click handler:
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, JSON_URL, null,
                    (response) -> {
                        try {
                            ListEntry addNew = new ListEntry(" "," "," ");
                            try {
                                JSONArray drinksArray = response.getJSONArray("drinks");

                                for (int i = 0; i < drinksArray.length(); i++) {

                                    JSONObject cocktailJson = drinksArray.getJSONObject(i);


                                    addNew.setName(cocktailJson.getString("strDrink"));
                                    addNew.setCategory(cocktailJson.getString("strCategory"));
                                    addNew.setOther(cocktailJson.getString("strInstructions"));

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            newEntry.add(addNew);
                            setuprecyclerview(newEntry);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    },
                    (error) -> {
                        Log.e("TAG", "error");
                    });
            queue.add(request);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    private void setuprecyclerview(List<ListEntry> lstAnime) {


        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,newEntry) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);

    }
}