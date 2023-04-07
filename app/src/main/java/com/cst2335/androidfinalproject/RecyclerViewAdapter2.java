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




public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.MyViewHolder> {

    private Context mContext ;
    private List<ListEntry> mData ;

    RequestOptions option;

public RecyclerViewAdapter2(){}
    public RecyclerViewAdapter2(Context mContext, List<ListEntry> mData) {
        this.mContext = mContext;
        this.mData = mData;


        // Request option for Glide
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

                Intent i = new Intent(mContext, MyListView.class);
                i.putExtra("name", mData.get(viewHolder.getAdapterPosition()).getName());

                i.putExtra("category", mData.get(viewHolder.getAdapterPosition()).getCategory());

                i.putExtra("others", mData.get(viewHolder.getAdapterPosition()).getOther());
                i.putExtra("id", mData.get(viewHolder.getAdapterPosition()).getId());

                mContext.startActivity(i);

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(mData.get(position).getName());
        holder.category.setText(mData.get(position).getOther());
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