package com.h2physics.instagram.data.remote.api;

import com.h2physics.instagram.data.model.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by YukiNoHara on 10/8/2017.
 */

public interface ISearchedPhotos {
    @GET("search/photos")
    Call<List<Photo>> getSearchedPhotos (@Query("query") String query,
                                         @Query("page") int page,
                                         @Query("per_page") int perPage);
}
