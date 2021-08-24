package com.example.movietdb;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ModelClass {
    @SerializedName("page")
    private String page;
    @SerializedName("results")
    private ArrayList <ResponseModel > responseModels;
    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public ArrayList<ResponseModel> getResponseModels() {
        return responseModels;
    }

    public void setResponseModels(ArrayList<ResponseModel> responseModels) {
        this.responseModels = responseModels;
    }
}
