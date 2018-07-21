package com.example.mohamedelnhrawy.baseproject.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by mohamedelnhrawy on 7/21/18.
 */

public class Movie implements Serializable {

    @Expose
    @SerializedName("bio")
    private String bio;
    @Expose
    @SerializedName("imageurl")
    private String imageurl;
    @Expose
    @SerializedName("publisher")
    private String publisher;
    @Expose
    @SerializedName("createdby")
    private String createdby;
    @Expose
    @SerializedName("firstappearance")
    private String firstappearance;
    @Expose
    @SerializedName("team")
    private String team;
    @Expose
    @SerializedName("realname")
    private String realname;
    @Expose
    @SerializedName("name")
    private String name;

    public String getBio() {
        return bio;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getCreatedby() {
        return createdby;
    }

    public String getFirstappearance() {
        return firstappearance;
    }

    public String getTeam() {
        return team;
    }

    public String getRealname() {
        return realname;
    }

    public String getName() {
        return name;
    }

    public Movie() {
    }

    public Movie(String bio, String imageurl, String publisher, String createdby, String firstappearance, String team, String realname, String name) {
        this.bio = bio;
        this.imageurl = imageurl;
        this.publisher = publisher;
        this.createdby = createdby;
        this.firstappearance = firstappearance;
        this.team = team;
        this.realname = realname;
        this.name = name;
    }
}
