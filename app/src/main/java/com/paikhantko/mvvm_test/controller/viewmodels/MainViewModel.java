package com.paikhantko.mvvm_test.controller.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.paikhantko.mvvm_test.controller.repositories.Covid19Repository;
import com.paikhantko.mvvm_test.models.entities.Row;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private final Covid19Repository repo;

    public MainViewModel(@NonNull Application application, Covid19Repository covid19Repository) {
        super(application);
        this.repo=covid19Repository;
    }

    public LiveData<List<Row>> getAllRows(){
        return repo.getRows();
    }
}
