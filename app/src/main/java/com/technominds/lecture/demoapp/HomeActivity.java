package com.technominds.lecture.demoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.technominds.lecture.demoapp.adapters.Myrecyclerview;
import com.technominds.lecture.demoapp.models.intromodel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    Myrecyclerview adapter;
    List<intromodel> listmodels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
         initref();
         toolbar.setTitleTextColor(getResources().getColor(R.color.white));
         setSupportActionBar(toolbar);
        getWindow().setStatusBarColor(getResources().getColor(R.color.primary));


        adapter=new Myrecyclerview(this,createlist());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    private List<intromodel> createlist() {
        intromodel m1=new intromodel(R.mipmap.img1,"Title1","Description1");
        intromodel m2=new intromodel(R.mipmap.img2,"Title2","Description2");
        intromodel m3=new intromodel(R.mipmap.img3,"Title3","Description3");
        listmodels.add(m1);
        listmodels.add(m2);
        listmodels.add(m3);
        return listmodels;
    }


    private void initref() {
        toolbar=findViewById(R.id.toolbar);
        recyclerView=findViewById(R.id.recyclerview);
        listmodels=new ArrayList<>();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tool_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu1:
                startActivity(new Intent(HomeActivity.this,AddPerson.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}