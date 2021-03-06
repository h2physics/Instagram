package com.h2physics.instagram.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by YukiNoHara on 10/7/2017.
 */

public class Photo {
    @SerializedName("id")
    @Expose
    private String mId;
    @SerializedName("likes")
    @Expose
    private int likes;
    @SerializedName("description")
    @Expose
    private String mDescription;
    @SerializedName("user")
    @Expose
    private User mUser;
    @SerializedName("urls")
    @Expose
    private Urls mUrl;

    public String getId() {
        return mId;
    }

    public int getLikes() {
        return likes;
    }

    public String getDescription() {
        return mDescription;
    }

    public User getUser() {
        return mUser;
    }

    public Urls getUrl() {
        return mUrl;
    }

    public Photo(String mId, int likes, User mUser, Urls mUrl) {
        this.mId = mId;
        this.likes = likes;
        this.mUser = mUser;
        this.mUrl = mUrl;
    }


    //    private Builder builder;
//
//    public Photo(Builder builder) {
//        this.builder = builder;
//    }
//
//    public Builder getBuilder() {
//        return builder;
//    }
//
//    public static class Builder{
//        private String mId;
//        private int likes;
//        private User mUser;
//        private String mUrl;
//
//        public String getId() {
//            return mId;
//        }
//
//        public Builder setId(String id) {
//            this.mId = id;
//            return this;
//        }
//
//        public int getLikes() {
//            return likes;
//        }
//
//        public Builder setLikes(int likes) {
//            this.likes = likes;
//            return this;
//        }
//
//        public User getUser() {
//            return mUser;
//        }
//
//        public Builder setUser(User mUser) {
//            this.mUser = mUser;
//            return this;
//        }
//
//        public String getUrl() {
//            return mUrl;
//        }
//
//        public Builder setUrl(String mUrl) {
//            this.mUrl = mUrl;
//            return this;
//        }
//    }
}
