package com.paikhantko.mvvm_test.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.paikhantko.mvvm_test.R;
import com.paikhantko.mvvm_test.controller.viewmodels.MainViewModel;
import com.paikhantko.mvvm_test.controller.viewmodels.MainViewModelFactory;
import com.paikhantko.mvvm_test.databinding.ActivityMainBinding;
import com.paikhantko.mvvm_test.ui.adapter.RowsAdapter;
import com.paikhantko.mvvm_test.ui.delegates.TextInputDialogDelegate;
import com.paikhantko.mvvm_test.ui.delegates.TextsItemDelegate;
import com.paikhantko.mvvm_test.utils.InjectorUtils;

import java.util.ArrayList;
import java.util.Objects;


public class MainActivity extends AppCompatActivity implements TextInputDialogDelegate, TextsItemDelegate {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding=DataBindingUtil.setContentView(this,R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MainViewModelFactory factory = InjectorUtils.provideMainViewModelFactory(getApplication());
        MainViewModel mViewModel = new ViewModelProvider(this, factory).get(MainViewModel.class);

        binding.rvText.setAdapter(new RowsAdapter(new ArrayList<>()));
        binding.setViewmodel(mViewModel);

        binding.getViewmodel().loadData().observe(this, rows -> ((RowsAdapter) Objects.requireNonNull(binding.rvText.getAdapter())).setRows(rows));
    }

}