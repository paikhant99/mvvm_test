package com.paikhantko.mvvm_test.di.modules;

import android.app.Application;

import androidx.room.Room;

import com.google.gson.Gson;
import com.paikhantko.mvvm_test.models.local.LocalDataSource;
import com.paikhantko.mvvm_test.models.local.database.AppRoomDatabase;
import com.paikhantko.mvvm_test.models.network.ApiService;
import com.paikhantko.mvvm_test.models.network.RemoteDataSource;
import com.paikhantko.mvvm_test.utils.AppConstants;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Singleton
    @Provides
    RemoteDataSource provideRemoteDataSource(){
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(40, TimeUnit.SECONDS)
                .build();

        ApiService service=new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build().create(ApiService.class);
        return new RemoteDataSource(service);
    }



    @Singleton
    @Provides
    LocalDataSource provideLocalDataSource(AppRoomDatabase database){
        return new LocalDataSource(database.rowDao());
    }

    @Singleton
    @Provides
    AppRoomDatabase provideAppRoomDatabase(Application application){
        return Room.databaseBuilder(application.getApplicationContext(),
                AppRoomDatabase.class, AppConstants.DATABASE_NAME)
                .build();
    }
}
