package com.niksharma.practice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    private String[] data,actor;
    private int[] images;
    private AppCompatActivity context;
    public MyAdapter(AppCompatActivity context, String[] data, String[] actor, int[] images)
    {
        this.context=context;
        this.data=data;
        this.actor=actor;
        this.images=images;

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView movieText,actorText;
        private ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.movieText = itemView.findViewById(R.id.textView1);
            this.actorText = itemView.findViewById(R.id.textView2);
            this.imageView = itemView.findViewById(R.id.imageView);
            }
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =inflater.inflate(R.layout.view_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.movieText.setText(data[position]);
        holder.actorText.setText(actor[position]);
        holder.imageView.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }
}