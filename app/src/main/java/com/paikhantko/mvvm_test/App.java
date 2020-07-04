package com.paikhantko.mvvm_test;

import android.app.Application;

import com.paikhantko.mvvm_test.di.components.ApplicationComponent;
import com.paikhantko.mvvm_test.di.components.DaggerApplicationComponent;

public class App extends Application {
    ApplicationComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerApplicationComponent.factory().create(this);
    }

    public ApplicationComponent getAppComponent(){
        return appComponent;
    }
}
