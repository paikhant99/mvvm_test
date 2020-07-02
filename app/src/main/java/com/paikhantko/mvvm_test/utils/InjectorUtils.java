package com.paikhantko.mvvm_test.utils;

import android.app.Application;
import android.content.Context;

import com.paikhantko.mvvm_test.controller.repositories.Covid19Repository;
import com.paikhantko.mvvm_test.controller.viewmodels.MainViewModelFactory;
import com.paikhantko.mvvm_test.models.database.AppRoomDatabase;

public class InjectorUtils {

    private static Covid19Repository getCovid19Repository(Context context){
        return Covid19Repository.getInstance(AppRoomDatabase.getDatabase(context).rowDao());
    }

    public static MainViewModelFactory provideMainViewModelFactory(Application application){
        Covid19Repository repository = getCovid19Repository(application);
        return new MainViewModelFactory(application,repository);
    }
}
