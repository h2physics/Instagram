package com.h2physics.instagram.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by YukiNoHara on 10/7/2017.
 */

public class User implements Serializable{
    @SerializedName("id")
    @Expose
    private String mId;
    @SerializedName("username")
    @Expose
    private String mUsername;
    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("portfolio_url")
    @Expose
    private String mUserUrl;
    @SerializedName("bio")
    @Expose
    private String mBiography;
    @SerializedName("location")
    @Expose
    private String mLocation;
    @SerializedName("total_likes")
    @Expose
    private int totalLikes;
    @SerializedName("total_photos")
    @Expose
    private int totalPhotos;
    @SerializedName("profile_image")
    @Expose
    private ProfileImage mProfileImage;

    public String getId() {
        return mId;
    }

    public String getUsername() {
        return mUsername;
    }

    public String getName() {
        return mName;
    }

    public String getUserUrl() {
        return mUserUrl;
    }

    public String getBiology() {
        return mBiography;
    }

    public String getLocation() {
        return mLocation;
    }

    public int getTotalLikes() {
        return totalLikes;
    }

    public int getTotalPhotos() {
        return totalPhotos;
    }

    public ProfileImage getmProfileImage() {
        return mProfileImage;
    }

    public User(String mId, String mUsername, String mName, String mUserUrl, String mBiography, String mLocation, int totalLikes, int totalPhotos, ProfileImage mProfileImage) {
        this.mId = mId;
        this.mUsername = mUsername;
        this.mName = mName;
        this.mUserUrl = mUserUrl;
        this.mBiography = mBiography;
        this.mLocation = mLocation;
        this.totalLikes = totalLikes;
        this.totalPhotos = totalPhotos;
        this.mProfileImage = mProfileImage;
    }
}
