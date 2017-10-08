package com.h2physics.instagram.ui.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.BaseAdapter;

import com.h2physics.instagram.R;
import com.h2physics.instagram.data.model.Photo;
import com.h2physics.instagram.data.model.ProfileImage;
import com.h2physics.instagram.data.model.Urls;
import com.h2physics.instagram.data.model.User;
import com.h2physics.instagram.data.remote.api.Client;
import com.h2physics.instagram.data.remote.api.GetAllPhoto;
import com.h2physics.instagram.ui.adapter.PhotoAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity {
    private List<Photo> photoList;
    private PhotoAdapter adapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        String url = "http://hinhanhdepvip.com/wp-content/uploads/2016/07/girl-xinh-dep-tu-nhien.jpg";
        Urls urls = new Urls(url);
        ProfileImage profileImage = new ProfileImage("http://hinhanhdepvip.com/wp-content/uploads/2016/07/girl-xinh-dep-tu-nhien.jpg");
        User user = new User("1","abc","Tran A","aaadd","ddfd","dfsdf",12,10,profileImage);
        Photo photo = new Photo("dfd",12, user, urls);

        photoList = new ArrayList<>();
        for (int i=0 ; i<10;i++){
            photoList.add(photo);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new PhotoAdapter(this);
        adapter.addAll(photoList);
        recyclerView.setAdapter(adapter);
        pullData();
    }

    private void pullData() {
        photoList = new ArrayList<>();
        GetAllPhoto getAllPhotoModel = Client.getInstance().create(GetAllPhoto.class);
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
