package com.example.BrowseFragmentUsingRetrofit;

import com.example.BrowseFragmentUsingRetrofit.Model.Cvte;
import com.example.BrowseFragmentUsingRetrofit.Model.deeplinkResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface APIs {

    @GET("cats/assets/cvte.json")
    Call<Cvte> getphotos();


    @POST
    Call<deeplinkResponse> createPost(@Url String url, @HeaderMap Map<String,String> headerField, @Body Object fields);
}
