package com.paikhantko.mvvm_test.models.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.paikhantko.mvvm_test.models.entities.Row;

import java.util.List;

@Dao
public interface DataDao {

    @Query("Select * from row_table")
    LiveData<List<Row>> getData();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRow(Row row);
}
