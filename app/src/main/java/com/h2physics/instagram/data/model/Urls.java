package com.h2physics.instagram.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by trongphuong1011 on 10/7/2017.
 */

public class Urls {
    @SerializedName("full")
    @Expose
    private String full;

    public String getFull() {
        return full;
    }
}
