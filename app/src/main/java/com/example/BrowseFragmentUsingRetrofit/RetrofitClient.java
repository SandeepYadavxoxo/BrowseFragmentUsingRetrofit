package com.example.BrowseFragmentUsingRetrofit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static  RetrofitClient instance = null;
    private final APIs apis;

    private RetrofitClient(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request originalRequest = chain.request();

                        Request newRequest = originalRequest.newBuilder()
                                .header("HeaderKey","HeaderValue")
                                .build();

                        return chain.proceed(newRequest);
                    }
                })
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://asset.s4.cloudwalker.tv/").
                addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
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
