package com.paikhantko.mvvm_test.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.paikhantko.mvvm_test.App;
import com.paikhantko.mvvm_test.R;
import com.paikhantko.mvvm_test.controller.viewmodels.MainViewModel;
import com.paikhantko.mvvm_test.databinding.ActivityMainBinding;
import com.paikhantko.mvvm_test.ui.adapter.RowsAdapter;

import java.util.ArrayList;
import java.util.Objects;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {

    @Inject
    ViewModelProvider.Factory viewmodelfactory;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((App) getApplication()).getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding=DataBindingUtil.setContentView(this,R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mainViewModel=viewmodelfactory.create(MainViewModel.class);

        binding.rvText.setAdapter(new RowsAdapter(new ArrayList<>()));
        binding.setViewmodel(mainViewModel);

        binding.getViewmodel().loadData().observe(this, rows -> ((RowsAdapter) Objects.requireNonNull(binding.rvText.getAdapter())).setRows(rows));
    }

}