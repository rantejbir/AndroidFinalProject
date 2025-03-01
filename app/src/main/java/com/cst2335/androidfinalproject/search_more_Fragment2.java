package com.cst2335.androidfinalproject;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.cst2335.androidfinalproject.MainActivity;

public class search_more_Fragment2 extends Fragment {

    private EditText searchText;

    private Button btn;
    public static final String SHARED = "sharedPrefs";
    public String search2 = "text2";

    public search_more_Fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_more_2, container, false);

        searchText = view.findViewById(R.id.username);

        btn = view.findViewById(R.id.search);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String name1 = sharedPreferences.getString(search2, "");
        searchText.setText(name1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String str = searchText.getText().toString();
                editor.putString(search2,str);
                editor.apply();
                Intent i = new Intent(getActivity(), MainActivity.class);
                i.putExtra("search",str);
                startActivity(i);
            }
        });

        return view;
    }
}
