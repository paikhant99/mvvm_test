package com.paikhantko.mvvm_test.controller.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.paikhantko.mvvm_test.models.daos.TextDao;
import com.paikhantko.mvvm_test.models.database.TextRoomDatabase;
import com.paikhantko.mvvm_test.models.entities.Text;

import java.util.List;

public class TextRepository {

    private TextDao mTextDao;
    private LiveData<List<Text>> mAllTexts;

    public TextRepository(Application application) {
        TextRoomDatabase db = TextRoomDatabase.getDatabase(application);
        mTextDao = db.textDao();
        mAllTexts = mTextDao.getAllTexts();
    }

    public LiveData<List<Text>> getAllTexts() {
        return mAllTexts;
    }

    public void insert(final Text text) {
        TextRoomDatabase.databaseWriteExecutor.execute(() -> {
            mTextDao.insert(text);
        });
    }
}
