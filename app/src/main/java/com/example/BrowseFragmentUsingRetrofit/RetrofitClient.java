package com.example.BrowseFragmentUsingRetrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static  RetrofitClient instance = null;
    private  APIs apis;


    private RetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(APIs.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).build();
        apis = retrofit.create(APIs.class);
    }

    public  static  RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }
    public APIs getApis(){
        return  apis;
    }

}
