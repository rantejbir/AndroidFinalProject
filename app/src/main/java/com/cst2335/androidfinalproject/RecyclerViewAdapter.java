package com.cst2335.androidfinalproject;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


import java.util.List;




public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<ListEntry> mData ;
    RequestOptions option;


    public RecyclerViewAdapter(Context mContext, List<ListEntry> mData) {
        this.mContext = mContext;
        this.mData = mData;

        // Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading).error(R.drawable.loading);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.activity_list,parent,false) ;





        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_rating.setText(mData.get(position).getOther());
//        holder.tv_studio.setText(mData.get(position).getId());
        holder.tv_category.setText(mData.get(position).getCategory());



        Glide.with(mContext).load("https://2039028l.ha.azioncdn.net/img/2023/02/produto/17477/03-maquina-solda-inversora-200a-alumig-200dp-boxer.png?ims=fit-in/800x800/filters:fill(white)").apply(option).into(holder.img_thumbnail);



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name ;
        TextView tv_rating ;
        TextView tv_studio ;
        TextView tv_category;
        ImageView img_thumbnail;
//        LinearLayout view_container;





        public MyViewHolder(View itemView) {
            super(itemView);
//
//            view_container = itemView.findViewById(R.id.container);
            tv_name = itemView.findViewById(R.id.anime_name);
            tv_category = itemView.findViewById(R.id.categorie);
            tv_rating = itemView.findViewById(R.id.rating);
            tv_studio = itemView.findViewById(R.id.studio);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);

        }
    }

}