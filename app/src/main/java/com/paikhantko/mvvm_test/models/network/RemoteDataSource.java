package com.paikhantko.mvvm_test.models.network;


import com.paikhantko.mvvm_test.models.entities.*;

import io.reactivex.Single;

public class RemoteDataSource {
    private static RemoteDataSource INSTANCE;
    private final ApiService mApiService= RetrofitInstance.getInstance().create(ApiService.class);

    private RemoteDataSource() {
    }

    public static RemoteDataSource getRemoteDataSourceInstance(){
        if(INSTANCE==null){
            INSTANCE=new RemoteDataSource();
        }
        return INSTANCE;
    }

    public Single<Covid19Response> getCovid19Response(){
        return mApiService.getData();
    }
}
