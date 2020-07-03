package com.paikhantko.mvvm_test.controller.viewmodels;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.paikhantko.mvvm_test.controller.repositories.Covid19Repository;
import com.paikhantko.mvvm_test.models.entities.Row;

import java.util.List;


public class MainViewModel extends AndroidViewModel {

    private final Covid19Repository repo;
    private final MutableLiveData<List<Row>> rowList;
    private ObservableField<Boolean> isLoading;

    public MainViewModel(@NonNull Application application, Covid19Repository covid19Repository) {
        super(application);
        this.repo = covid19Repository;
        isLoading = new ObservableField<>();
        rowList = new MutableLiveData<>();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @SuppressLint("CheckResult")
    public LiveData<List<Row>> loadData() {
        isLoading.set(true);
        repo.getRows().subscribe(rows -> {
            rowList.postValue(rows);
            isLoading.set(false);
        });
        return rowList;
    }

    public ObservableField<Boolean> getIsLoading() {
        return isLoading;
    }

    public void setIsLoading(ObservableField<Boolean> isLoading) {
        this.isLoading = isLoading;
    }
}
