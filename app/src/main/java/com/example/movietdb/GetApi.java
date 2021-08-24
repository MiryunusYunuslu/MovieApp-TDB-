package com.example.movietdb;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetApi {
    @GET("popular?api_key=194d401d250145e43e1a84a95f03ab6f&language=en-US")
    Call <ModelClass> callapi();
    @GET("{type}")
    Call <ModelClass> calltype(
            @Path("type") String type,
    @Query("api_key") String api_key,
    @Query("language") String language
    );



}
