package com.paikhantko.mvvm_test.models.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.paikhantko.mvvm_test.models.daos.DataDao;
import com.paikhantko.mvvm_test.models.entities.Row;
import com.paikhantko.mvvm_test.utils.AppConstants;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Row.class}, version = 1, exportSchema = false)
public abstract class AppRoomDatabase extends RoomDatabase {

    //    public abstract TextDao textDao();
    public abstract DataDao rowDao();

    private static volatile AppRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppRoomDatabase.class, AppConstants.DATABASE_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
