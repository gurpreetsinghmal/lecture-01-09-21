package com.technominds.lecture.demoapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.technominds.lecture.demoapp.R;
import com.technominds.lecture.demoapp.models.*;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class introadapter extends PagerAdapter {

    List<intromodel> list;
    Context ctx;

    public introadapter(List<intromodel> list, Context ctx) {
        this.list = list;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View v= LayoutInflater.from(ctx).inflate(R.layout.modallayoutviewpager,container,false);
        ImageView image=v.findViewById(R.id.imvintro);
        TextView ti=v.findViewById(R.id.tvtitle);
        TextView td=v.findViewById(R.id.tvdesc);

        image.setImageResource(list.get(position).getImages());
        ti.setText(list.get(position).getTitle());
        td.setText(list.get(position).getDesciption());
        container.addView(v);
        return v;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
