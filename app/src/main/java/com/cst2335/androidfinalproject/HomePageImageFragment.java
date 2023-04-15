package com.cst2335.androidfinalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * This Java class represents a straightforward fragment that shows an image on an Android application's home page.
 * The fragment only has a static image and no logic. It has a default constructor and the initialization parameters for
 * the fragment are stored in two private string arguments called mParam1 and mParam2. The factory method of the fragment,
 * newInstance(), produces a fresh instance of the fragment using the supplied inputs. The fragment's onCreate() method retrieves
 * the arguments that were supplied to it when it was constructed and stores them in the instance variables. Last but not least,
 * the onCreateView() method expands the fragment's layout to include an ImageView that shows the image on the home page.
 */

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomePageImageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomePageImageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomePageImageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomePageImageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomePageImageFragment newInstance(String param1, String param2) {
        HomePageImageFragment fragment = new HomePageImageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_img, container, false);
    }
}