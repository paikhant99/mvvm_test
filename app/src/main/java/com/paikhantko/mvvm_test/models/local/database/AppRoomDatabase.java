package com.paikhantko.mvvm_test.models.local.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.paikhantko.mvvm_test.models.local.daos.DataDao;
import com.paikhantko.mvvm_test.models.entities.Row;

@Database(entities = {Row.class}, version = 1, exportSchema = false)
public abstract class AppRoomDatabase extends RoomDatabase {

    public abstract DataDao rowDao();
}
