package com.h2physics.instagram.data.remote.api;

import com.h2physics.instagram.data.model.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by trongphuong1011 on 10/7/2017.
 */

public interface GetAllPhoto {
    @GET("photos")
    Call<List<Photo>> getAllPhoto(@Query("per_page") int number);
}
