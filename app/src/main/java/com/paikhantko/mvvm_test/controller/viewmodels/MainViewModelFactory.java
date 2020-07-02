package com.paikhantko.mvvm_test.controller.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.paikhantko.mvvm_test.controller.repositories.Covid19Repository;

public class MainViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final Application application;
    private final Covid19Repository covidRepo;

    public MainViewModelFactory(Application application,Covid19Repository covid19Repository) {
        this.application=application;
        this.covidRepo=covid19Repository;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainViewModel(application, covidRepo);
    }
}
