package com.example.BrowseFragmentUsingRetrofit;

import com.example.BrowseFragmentUsingRetrofit.Model.Cvte;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIs {

    String BASE_URL = "http://asset.s4.cloudwalker.tv/";

    @GET("cats/assets/cvte.json")
    Call<Cvte> getphotos();
}
