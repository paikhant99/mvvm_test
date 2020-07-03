package com.paikhantko.mvvm_test.controller.repositories;


import com.paikhantko.mvvm_test.models.daos.DataDao;
import com.paikhantko.mvvm_test.models.entities.Row;
import com.paikhantko.mvvm_test.models.network.RemoteDataSource;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class Covid19Repository {

    protected final RemoteDataSource dataSource = RemoteDataSource.getRemoteDataSourceInstance();
    private final DataDao dataDao;
    private static Covid19Repository REPO;

    public Covid19Repository(DataDao dataDao) {
        this.dataDao = dataDao;
    }

    public static Covid19Repository getInstance(DataDao dataDao) {
        if (REPO == null) {
            REPO = new Covid19Repository(dataDao);
        }
        return REPO;
    }

    public Single<List<Row>> getRows() {
        return dataSource.getCovid19Response()
                .flatMap(covid19Response -> {
                    for (Row row : covid19Response.getData().getRows()){
                        dataDao.insertRow(row);
                    }
                    return dataDao.getData().toSingle();
                })
                .onErrorResumeNext(throwable -> dataDao.getData().toSingle())
                .subscribeOn(Schedulers.io());


    }

}
