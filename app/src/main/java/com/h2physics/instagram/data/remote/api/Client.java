package com.h2physics.instagram.data.remote.api;

import android.content.Context;

import com.h2physics.instagram.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by YukiNoHara on 10/7/2017.
 */

public class Client {
    private static Retrofit retrofit;
    private static Client instance;
    public static Client getInstance(Context context){
        if (instance == null){
            instance = new Client(context);
        }
        return instance;
    }

    private Client(Context context){
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder builder = request.newBuilder();
                builder.header("Authorization","Client-ID "+"e3dc0ab6aa3acff4b54301f11e866950fe261bde4afbfcb2dfd4f7cd92fa3756");
                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        });
        if(BuildConfig.DEBUG){
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClientBuilder.addInterceptor(loggingInterceptor);
        }
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.unsplash.com/")
                .addConverterFactory(GsonConverterFactory.create()).callFactory(httpClientBuilder.build()).build();
    }
    public <T> T create (final  Class<T> service){
        return retrofit.create(service);
    }
}
