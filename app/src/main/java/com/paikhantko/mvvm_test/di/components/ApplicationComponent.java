package com.paikhantko.mvvm_test.di.components;

import android.app.Application;

import com.paikhantko.mvvm_test.controller.repositories.Covid19Repository;
import com.paikhantko.mvvm_test.di.modules.AppModule;
import com.paikhantko.mvvm_test.di.modules.ViewModelModule;
import com.paikhantko.mvvm_test.ui.activities.MainActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class,ViewModelModule.class})
public interface ApplicationComponent {

    @Component.Factory
    interface Factory{

        ApplicationComponent create(@BindsInstance Application application);

    }

    Covid19Repository repository();

    void inject(MainActivity mainActivity);
}