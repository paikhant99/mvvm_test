package com.paikhantko.mvvm_test.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.paikhantko.mvvm_test.controller.viewmodels.MainViewModel;
import com.paikhantko.mvvm_test.controller.viewmodels.MainViewModelFactory;
import com.paikhantko.mvvm_test.di.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(MainViewModelFactory mainViewModelFactory);

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel mainViewModel);
}
