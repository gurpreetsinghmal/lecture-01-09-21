package com.technominds.lecture.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.technominds.lecture.demoapp.adapters.introadapter;
import com.technominds.lecture.demoapp.models.intromodel;

import java.util.ArrayList;
import java.util.List;

public class IntroSlide extends AppCompatActivity {

    ViewPager viewPager;
    List<intromodel> mylist=new ArrayList<>();
    introadapter introadapter;
    TabLayout tabs;
    Button getstarted;
    Animation btnanim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(readpref()) //already visited
        {
            movetosplash();
        }

        setContentView(R.layout.activity_intro_slide);


        viewPager=findViewById(R.id.viewpager);
        tabs=findViewById(R.id.tablayout);
        getstarted=findViewById(R.id.getstarted);
        btnanim= AnimationUtils.loadAnimation(this,R.anim.btnanim);

        mylist.add(new intromodel(R.mipmap.img1,"Food Delivery","I ma using dummy text1"));
        mylist.add(new intromodel(R.mipmap.img2,"Tasty Food","I ma using dummy text2"));
        mylist.add(new intromodel(R.mipmap.img3,"Online Payment","I ma using dummy text3"));
        introadapter=new introadapter(mylist,this);
        viewPager.setAdapter(introadapter);

        tabs.setupWithViewPager(viewPager);

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==mylist.size()-1)
                {
                    getstarted.setVisibility(View.VISIBLE);
                    getstarted.startAnimation(btnanim);
                }
                else
                {
                    getstarted.setVisibility(View.GONE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void gonext(View view) {
        int position=viewPager.getCurrentItem();
        if(position<mylist.size()-1)
        {
            position++;
            viewPager.setCurrentItem(position);
        }
    }

    public void getstarted(View view) {
        savepref();
        movetosplash();
    }

    private void movetosplash() {
        Intent i=new Intent(this,SplashScreen.class);
        startActivity(i);
        finish();
    }

    private void savepref() {
        // store device pref variable
        SharedPreferences pref=getSharedPreferences("check",MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putBoolean("alreadyvisited",true);
        editor.commit();

    }
    private boolean readpref() {
        SharedPreferences preferences=getSharedPreferences("check",MODE_PRIVATE);
        return preferences.getBoolean("alreadyvisited",false);
    }
}