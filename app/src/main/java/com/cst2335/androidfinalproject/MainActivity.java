package com.cst2335.androidfinalproject;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.widget.Button;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import android.widget.Toast;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;




import java.util.ArrayList;
import java.util.List;

/**
 * Author: Daksh Sharma
 * Date updated: 8/4/2023
 * purpose: With the help of the Volley library, this class aims to provide a user interface for a primary
 * activity that presents a list of items that were obtained from an API request.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * The code then gets a search phrase from the previous activity that was supplied as an extra
     * in the intent and uses it to create a URL for an API call. The user can see the search word
     * by seeing a Toast.
     * There are two separate buttons set up with two click listeners each:
     * When the "MyList" button is pressed, a new activity titled "HomePage" is launched.
     * When the "more" button is clicked, a new activity titled "MainActivity2" is shown.
     */
    String URL = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=";

    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<ListEntry> newEntry1;
    private ListDao mDAO;
    private RecyclerView recyclerView;
    protected RequestQueue queue = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newEntry1 = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerviewid);

        queue = Volley.newRequestQueue(this);

        Intent intent = getIntent();
        String search = intent.getStringExtra("search");
        search = search.trim();
        String JSON_URL = URL + search + "&appid=1";
        /**
         * Toast message for search fragment
         */
        Toast.makeText(this, search, Toast.LENGTH_LONG).show();
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btn3 = findViewById(R.id.MyList);
        btn3.setOnClickListener(clk -> {
            Intent intent2 = new Intent(MainActivity.this, HomePage.class);
            startActivity(intent2);
        });
        Button btn4 = findViewById(R.id.more);
        btn4.setOnClickListener(clk -> {
            Intent Intent1 = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(Intent1);
        });
        try {

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, JSON_URL, null, (response) -> {
                try {
                    ListEntry addNew = new ListEntry(" ", " ", " ");
                    try {
                        JSONArray ArrayOfDrinks = response.getJSONArray("drinks");

                        for (int i = 0; i < ArrayOfDrinks.length(); i++) {
                            JSONObject cocktailJson = ArrayOfDrinks.getJSONObject(i);
                            addNew.setName(cocktailJson.getString("strDrink"));
                            addNew.setOther(cocktailJson.getString("strInstructions"));
                            addNew.setCategory(cocktailJson.getString("strCategory"));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    newEntry1.add(addNew);
                    setuprecyclerview(newEntry1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, (error) -> {
                Log.e("TAG", "there is an error");
            });
            queue.add(request);


        } catch (Exception exp) {
            throw new RuntimeException(exp);
        }
    }

    /**
     * here "setuprecyclerview" method sets up the RecyclerView with a new instance of the "RecyclerViewAdapter" class,
     * passing in the "newEntry" ArrayList and the current activity. It also sets the RecyclerView's layout manager and adapter.
     *
     * @param lstAnime
     */

    private void setuprecyclerview(List<ListEntry> lstAnime) {
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, newEntry1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }
}