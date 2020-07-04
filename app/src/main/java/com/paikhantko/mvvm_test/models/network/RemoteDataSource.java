package com.paikhantko.mvvm_test.models.network;


import com.paikhantko.mvvm_test.models.entities.*;

import javax.inject.Inject;

import io.reactivex.Single;

public class RemoteDataSource {

    private final ApiService mApiService;

    @Inject
    public RemoteDataSource(ApiService apiService) { //need to add @Inject
        this.mApiService=apiService;
    }

    public Single<Covid19Response> getCovid19Response(){
        return mApiService.getData();
    }
}
