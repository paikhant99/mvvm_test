package com.paikhantko.mvvm_test.models.network;

import com.google.gson.Gson;
import com.paikhantko.mvvm_test.utils.AppConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitInstance {

    private static Retrofit retrofit;

    public static Retrofit getInstance(){
        if (retrofit==null){
            final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(40, TimeUnit.SECONDS)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(AppConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
}
