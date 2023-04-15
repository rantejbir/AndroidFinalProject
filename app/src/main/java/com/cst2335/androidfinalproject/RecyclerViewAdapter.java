package com.cst2335.androidfinalproject;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;


import java.util.List;


/**
 * @author samar
 * date: 14/4/23
 *This Java class serves as an adaptor for an Android app's RecyclerView. It broadens RecyclerView.RecyclerView can render
 * list items thanks to an adapter class. The constructor of the RecyclerViewAdapter accepts two inputs: the context of the
 * application and a list of the data that will be shown in the RecyclerView. In order for the app to navigate to another screen
 * when a user clicks on an item in the RecyclerView, the onCreateViewHolder() method inflates the layout for each item in the
 * RecyclerView and sets up an OnClickListener for each item. The getItemCount() method returns
 * the number of items in the list, while the onBindViewHolder() method attaches the data to each item in the RecyclerView.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<ListEntry> mData ;
    RequestOptions option;


    public RecyclerViewAdapter(Context mContext, List<ListEntry> mData) {
        this.mContext = mContext;
        this.mData = mData;


        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading).error(R.drawable.loading);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.activity_list, parent, false);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, SingleEntryfromSearch.class);
                i.putExtra("name", mData.get(viewHolder.getAdapterPosition()).getName());

                i.putExtra("category", mData.get(viewHolder.getAdapterPosition()).getCategory());

                i.putExtra("others", mData.get(viewHolder.getAdapterPosition()).getOther());

                mContext.startActivity(i);

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(mData.get(position).getName());

        holder.category.setText(mData.get(position).getCategory());



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView category;
        TextView others;
        LinearLayout view_container;





        public MyViewHolder(View itemView) {
            super(itemView);
//
            view_container = itemView.findViewById(R.id.container);
            name = itemView.findViewById(R.id.name);
            category = itemView.findViewById(R.id.categorie);
            others = itemView.findViewById(R.id.aa_rating);



        }
    }

}