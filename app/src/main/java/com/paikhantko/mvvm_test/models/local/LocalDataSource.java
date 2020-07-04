package com.paikhantko.mvvm_test.models.local;

import com.paikhantko.mvvm_test.models.entities.Row;
import com.paikhantko.mvvm_test.models.local.daos.DataDao;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Maybe;

public class LocalDataSource {

    private final DataDao dataDao;

    @Inject
    public LocalDataSource(DataDao dataDao) {
        this.dataDao=dataDao;
    }

    public void insertRow(Row row){
        dataDao.insertRow(row);
    }

    public Maybe<List<Row>> getAllRows(){
        return dataDao.getData();
    }
}
