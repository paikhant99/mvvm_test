package com.paikhantko.mvvm_test.models.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.paikhantko.mvvm_test.models.entities.*;

import java.util.List;

@Dao
public interface TextDao {

    @Insert
    void insert(Text text);

    @Query("Update text_table set sentence=:sentence where id=:id")
    void update(int id,String sentence);

    @Query("Delete from text_table where id=:id")
    void delete(int id);

    @Query("Delete from text_table")
    void deleteAll();

    @Query("Select * from text_table")
    LiveData<List<Text>> getAllTexts();
}
