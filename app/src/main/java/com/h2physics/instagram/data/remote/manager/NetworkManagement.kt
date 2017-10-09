package com.h2physics.instagram.data.remote.manager

import android.content.Context
import com.h2physics.instagram.data.model.Photo
import com.h2physics.instagram.data.model.User
import com.h2physics.instagram.data.remote.api.Client
import com.h2physics.instagram.data.remote.api.GetAllPhoto
import com.h2physics.instagram.data.remote.api.ISearchedPhotos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by YukiNoHara on 10/7/2017.
 */

class NetworkManagement private constructor(context: Context?){
    private var INSTANCE : NetworkManagement? = null

    fun getInstance(context : Context?) : NetworkManagement?{
        if (INSTANCE == null){
            INSTANCE = NetworkManagement(context)
        }
        return INSTANCE;
    }

    fun getPhotos(context: Context?, callback : com.h2physics.instagram.data.remote.Callback<List<Photo>>) {
        val iPhoto : GetAllPhoto = Client.getInstance(context).create(GetAllPhoto::class.java)
        iPhoto.getAllPhoto(10).enqueue(object : Callback<List<Photo>> {
            override fun onResponse(call: Call<List<Photo>>?, response: Response<List<Photo>>?) {
                if (response!!.isSuccessful && response.code() == 200){
                    val photos : List<Photo>? = response.body();
                    callback.onSuccess(photos)
                }
            }

            override fun onFailure(call: Call<List<Photo>>?, t: Throwable?) {
                callback.onFailed()
            }
        })
    }

    fun getSearchedPhoto(context: Context?, key : String, callback: com.h2physics.instagram.data.remote.Callback<List<Photo>>){
        val iSearchedPhoto : ISearchedPhotos = Client.getInstance(context).create(ISearchedPhotos::class.java)
        iSearchedPhoto.getSearchedPhotos(key, 1, 10).enqueue(object : Callback<List<Photo>> {
            override fun onResponse(call: Call<List<Photo>>?, response: Response<List<Photo>>?) {
                if (response!!.isSuccessful && response.code() == 200){
                    val photos : List<Photo>? = response.body();
                    callback.onSuccess(photos)
                }
            }

            override fun onFailure(call: Call<List<Photo>>?, t: Throwable?) {
                callback.onFailed()
            }
        })
    }
}
