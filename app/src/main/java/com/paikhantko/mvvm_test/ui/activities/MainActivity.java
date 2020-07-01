package com.paikhantko.mvvm_test.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.paikhantko.mvvm_test.R;
import com.paikhantko.mvvm_test.controller.viewmodels.TextViewModel;
import com.paikhantko.mvvm_test.models.entities.Text;
import com.paikhantko.mvvm_test.ui.adapter.TextsAdapter;
import com.paikhantko.mvvm_test.ui.delegates.TextInputDialogDelegate;
import com.paikhantko.mvvm_test.ui.dialogs.TextInputDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TextInputDialogDelegate {

    private FloatingActionButton fab;
    private RecyclerView rvTexts;
    private TextsAdapter adapter;
    private List<Text> list;
    private TextViewModel mViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mViewModel= new ViewModelProvider(this).get(TextViewModel.class);

        list=new ArrayList<>();

        initiateViewId();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupDialogBox();
            }
        });

        adapter=new TextsAdapter(getApplicationContext(),new ArrayList<>());
        rvTexts.setLayoutManager(new LinearLayoutManager(this));
        rvTexts.setHasFixedSize(true);
        rvTexts.setAdapter(adapter);

        mViewModel.getAllTexts().observe(this, texts -> adapter.setTexts(texts));
    }

    private void initiateViewId(){
        fab=findViewById(R.id.fab);
        rvTexts=findViewById(R.id.rv_text);
    }

    private void popupDialogBox(){
        TextInputDialog dialog=new TextInputDialog(this);
        dialog.show(getSupportFragmentManager(),"Insert Text");
    }

    @Override
    public void onSaveClick(String sentence) {
        mViewModel.insert(new Text(sentence));
    }

}