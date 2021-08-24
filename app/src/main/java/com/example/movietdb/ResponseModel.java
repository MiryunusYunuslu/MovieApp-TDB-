package com.example.movietdb;

import com.google.gson.annotations.SerializedName;

public class ResponseModel {
    @SerializedName("original_title")
    private String  original_title;
    @SerializedName("poster_path")
    private String poster_path;
    @SerializedName("release_date")
    private String release_date;
    @SerializedName("overview")
    private String overview;

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }
    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
}