package com.h2physics.instagram.ui.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.h2physics.instagram.R;
import com.h2physics.instagram.data.model.Photo;
import com.h2physics.instagram.data.remote.api.Client;
import com.h2physics.instagram.data.remote.api.GetAllPhoto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity {
    private List<Photo> photoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        pullData();
    }

    private void pullData() {
        photoList = new ArrayList<>();
        GetAllPhoto getAllPhotoModel = Client.getInstance(this).create(GetAllPhoto.class);
        getAllPhotoModel.getAllPhoto(10).enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                photoList = response.body();
                Log.d("photoList ","" + response.body().size());
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

            }
        });
    }
}
