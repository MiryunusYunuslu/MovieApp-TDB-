package com.example.movietdb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private String baseurl = "https://api.themoviedb.org/3/movie/";
    private GetApi getApi;
    private RecyclerView recyclerView;
    private Adapter adapter;
    private ArrayList<ResponseModel> arrayList;
    private String typeofmovies = "popular";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList<>();
        sharedPreferences = this.getSharedPreferences("com.example.movietdb", MODE_PRIVATE);
        loadretrofit();
        loadmovies();


    }

    private void loadmovies() {
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new Adapter(arrayList, getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(adapter);
    }

    private void loadretrofit() {
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create(gson)).build();
        getApi = retrofit.create(GetApi.class);
        String name = sharedPreferences.getString("name", "popular");
        Call<ModelClass> call = getApi.calltype(name, "194d401d250145e43e1a84a95f03ab6f", "en-US");
        call.enqueue(new Callback<ModelClass>() {
            @Override
            public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {
                if (response.isSuccessful()) {
                    arrayList.addAll(response.body().getResponseModels());
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<ModelClass> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    public void popular(View view) {
        typeofmovies = "popular";
        sharedPreferences.edit().putString("name", typeofmovies).apply();
        finish();
        startActivity(getIntent());
    }
    public void toprated(View view) {
        typeofmovies = "top_rated";
        sharedPreferences.edit().putString("name", typeofmovies).apply();
        finish();
        startActivity(getIntent());
    }
    public void upcoming(View view) {
        typeofmovies = "upcoming";
        sharedPreferences.edit().putString("name", typeofmovies).apply();
        finish();
        startActivity(getIntent());
    }
}