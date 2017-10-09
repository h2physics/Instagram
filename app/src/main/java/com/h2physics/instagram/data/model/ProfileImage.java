package com.h2physics.instagram.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by trongphuong1011 on 10/7/2017.
 */

public class ProfileImage {
    @SerializedName("medium")
    @Expose
    private String medium;

    public String getMedium() {
        return medium;
    }

    public ProfileImage(String medium) {
        this.medium = medium;
    }
}
