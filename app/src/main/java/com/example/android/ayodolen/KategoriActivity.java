package com.example.android.ayodolen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.android.ayodolen.Adapter.RecyclerAdapterWisata;

import java.util.ArrayList;
import java.util.List;

public class KategoriActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<String> wisata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);


        Toolbar toolbar = findViewById(R.id.toolbarKategori);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Kategori Wisata");




        wisata = new ArrayList<>();
        initData();

        mRecyclerView = findViewById(R.id.rv_wisata);
        mLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerAdapterWisata(wisata,this);
        mRecyclerView.setAdapter(mAdapter);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(i);
                finish();
            }
        });


    }

    void initData(){
        wisata.add("Pantai A");
        wisata.add("Pantai B");
        wisata.add("Pantai C");
        wisata.add("Pantai D");
        wisata.add("Pantai E");

    }

}
