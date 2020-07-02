package com.paikhantko.mvvm_test.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.paikhantko.mvvm_test.R;
import com.paikhantko.mvvm_test.controller.viewmodels.MainViewModel;
import com.paikhantko.mvvm_test.controller.viewmodels.MainViewModelFactory;
import com.paikhantko.mvvm_test.ui.adapter.RowsAdapter;
import com.paikhantko.mvvm_test.ui.delegates.TextInputDialogDelegate;
import com.paikhantko.mvvm_test.ui.delegates.TextsItemDelegate;
import com.paikhantko.mvvm_test.utils.InjectorUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TextInputDialogDelegate, TextsItemDelegate {

    private RecyclerView rvTexts;
    private RowsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MainViewModelFactory factory = InjectorUtils.provideMainViewModelFactory(getApplication());
        MainViewModel mViewModel = new ViewModelProvider(this, factory).get(MainViewModel.class);

        initiateViewId();

        adapter = new RowsAdapter(getApplicationContext(), new ArrayList<>());
        rvTexts.setLayoutManager(new LinearLayoutManager(this));
        rvTexts.setHasFixedSize(true);
        rvTexts.setAdapter(adapter);

        mViewModel.getAllRows().observe(this, rows -> adapter.setRows(rows));
    }

    private void initiateViewId() {
//        fab=findViewById(R.id.fab);
        rvTexts = findViewById(R.id.rv_text);
    }

}