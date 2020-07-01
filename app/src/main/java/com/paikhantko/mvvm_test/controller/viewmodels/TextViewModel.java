package com.paikhantko.mvvm_test.controller.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.paikhantko.mvvm_test.controller.repositories.TextRepository;
import com.paikhantko.mvvm_test.models.entities.Text;

import java.util.List;

public class TextViewModel extends AndroidViewModel {

    private TextRepository mRepository;
    private LiveData<List<Text>> mAllTexts;

    public TextViewModel(@NonNull Application application) {
        super(application);
        mRepository = new TextRepository(application);
    }

    public LiveData<List<Text>> getAllTexts(){
        return mRepository.getAllTexts();
    }

    public void insert(Text text) { mRepository.insert(text); }


}
