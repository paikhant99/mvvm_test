package com.paikhantko.mvvm_test.controller.repositories;


import com.paikhantko.mvvm_test.models.local.LocalDataSource;
import com.paikhantko.mvvm_test.models.entities.Row;
import com.paikhantko.mvvm_test.models.network.RemoteDataSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class Covid19Repository {

    private final RemoteDataSource remoteDataSource;
    private final LocalDataSource localDataSource;

    @Inject
    public Covid19Repository(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource=remoteDataSource;
    }

    public Single<List<Row>> getRows() {
        return remoteDataSource.getCovid19Response()
                .flatMap(covid19Response -> {
                    for (Row row : covid19Response.getData().getRows()){
                        localDataSource.insertRow(row);
                    }
                    return localDataSource.getAllRows().toSingle();
                })
                .onErrorResumeNext(throwable -> localDataSource.getAllRows().toSingle())
                .subscribeOn(Schedulers.io());
    }

}
