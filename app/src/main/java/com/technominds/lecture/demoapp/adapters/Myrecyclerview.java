package com.technominds.lecture.demoapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.material.imageview.ShapeableImageView;
import com.technominds.lecture.demoapp.R;
import com.technominds.lecture.demoapp.models.intromodel;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Myrecyclerview extends RecyclerView.Adapter<Myrecyclerview.Myholder> {

    Context ctx;
    List<intromodel> listitems;

    public Myrecyclerview(Context ctx, List<intromodel> listitems) {
        this.ctx = ctx;
        this.listitems = listitems;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //creating layout here
        View v= LayoutInflater.from(ctx).inflate(R.layout.rec_item,parent,false);
        return new Myholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.img.setImageResource(listitems.get(position).getImages());
        holder.t1.setText(listitems.get(position).getTitle());
        holder.t2.setText(listitems.get(position).getDesciption());
        //bind widgets
    }

    @Override
    public int getItemCount() {
        return listitems.size();
    }

    class Myholder extends RecyclerView.ViewHolder
    {
        //instatiate the widgets
        ShapeableImageView img;
        TextView t1,t2;

        public Myholder(@NonNull View itemView) {
            super(itemView);

            //hookups
            img=itemView.findViewById(R.id.imv_rec);
            t1=itemView.findViewById(R.id.tv_t1);
            t2=itemView.findViewById(R.id.tv_t2);
        }
    }
}
