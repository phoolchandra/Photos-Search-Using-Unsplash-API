package com.phool.searchfavouritephotos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
//import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Intent i = getIntent();
        String s = i.getStringExtra("query");



        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        ImageViewModel model = new ViewModelProvider.AndroidViewModelFactory(this).get(ImageViewModel.class);
        ImageViewModel model = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ImageViewModel.class);


        model.getPhotos(s).observe(this, new Observer<List<Results>>() {
            @Override
            public void onChanged(@Nullable List<Results> PhotoList) {
                adapter = new ImageAdapter(ImageActivity.this, PhotoList);
                recyclerView.setAdapter(adapter);
            }
        });


    }
}
