package com.paikhantko.mvvm_test.controller.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.paikhantko.mvvm_test.models.daos.DataDao;
import com.paikhantko.mvvm_test.models.database.AppRoomDatabase;
import com.paikhantko.mvvm_test.models.entities.Covid19Response;
import com.paikhantko.mvvm_test.models.entities.Row;
import com.paikhantko.mvvm_test.models.network.RemoteDataSource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Covid19Repository {

    protected final RemoteDataSource dataSource = RemoteDataSource.getRemoteDataSourceInstance();
    private final DataDao dataDao;
    private static Covid19Repository REPO;

    public Covid19Repository(DataDao dataDao) {
        this.dataDao = dataDao;
    }

    public static Covid19Repository getInstance(DataDao dataDao){
        if (REPO==null){
            REPO=new Covid19Repository(dataDao);
        }
        return REPO;
    }

    public LiveData<List<Row>> getRows(){
        dataSource.getCovid19Response().enqueue(new Callback<Covid19Response>() {
            @Override
            public void onResponse(@NonNull Call<Covid19Response> call,@NonNull Response<Covid19Response> response) {
                Covid19Response covid19Response=response.body();
                assert covid19Response != null;
                for (Row row :covid19Response.getData().getRows()) {
                    AppRoomDatabase.databaseWriteExecutor.execute(() -> dataDao.insertRow(row));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Covid19Response> call,@NonNull Throwable t) {

            }
        });
        return dataDao.getData();

    }


}
