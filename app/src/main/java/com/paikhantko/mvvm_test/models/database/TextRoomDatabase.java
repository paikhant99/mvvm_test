package com.paikhantko.mvvm_test.models.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.paikhantko.mvvm_test.models.daos.TextDao;
import com.paikhantko.mvvm_test.models.entities.Text;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Text.class}, version = 1, exportSchema = false)
public abstract class TextRoomDatabase extends RoomDatabase {

    public abstract TextDao textDao();

    private static volatile TextRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static TextRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TextRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TextRoomDatabase.class, "text_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
