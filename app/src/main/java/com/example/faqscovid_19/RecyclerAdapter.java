package com.example.faqscovid_19;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    Context myContext;
    List<News> data;

    public RecyclerAdapter(Context myContext, List<News> data) {
        this.myContext = myContext;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View myView;
        myView = LayoutInflater.from(myContext).inflate(R.layout.template, parent,false);
        MyViewHolder viewHolder = new MyViewHolder(myView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.news_source.setText(data.get(position).getSource());
        holder.news_title.setText(data.get(position).getTitle());
        holder.news_date.setText(data.get(position).getDateTime());

        Glide.with(myContext).load(data.get(position).getUrlImage())
                .transform(new CenterCrop(), new RoundedCorners(30)).into(holder.news_image);

        holder.myLayout.setOnClickListener((v) ->{
            Intent newIntent = new Intent(Intent.ACTION_VIEW);
            newIntent.setData(Uri.parse(data.get(position).getLink()));
            myContext.startActivity(newIntent);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.template;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView news_source, news_title, news_date;
        ImageView news_image;
        LinearLayout myLayout;
        String link;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            news_image = itemView.findViewById(R.id.news_img);
            news_source = itemView.findViewById(R.id.news_source);
            news_title = itemView.findViewById(R.id.news_title);
            news_date = itemView.findViewById(R.id.news_date);
            myLayout = itemView.findViewById(R.id.news_layout);
        }
    }
}
