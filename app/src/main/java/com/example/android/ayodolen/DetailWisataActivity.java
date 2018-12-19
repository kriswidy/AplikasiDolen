package com.example.android.ayodolen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.ayodolen.Adapter.SectionsPageAdapter;
import com.example.android.ayodolen.Fragment.DeskripsiFragment;
import com.example.android.ayodolen.Fragment.KomentarFragment;
import com.example.android.ayodolen.Rest.ApiClient;
import com.squareup.picasso.Picasso;


public class DetailWisataActivity extends AppCompatActivity {

    TextView nama_wisata, alamat, deskripsi;
    ImageView img;
    ImageView imgWisata;
    FloatingActionButton btnMaps;
    String dsk, id_wisata;

    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);
        nama_wisata = findViewById(R.id.tvDetailNama);
        alamat = findViewById(R.id.tvDetailAlamat);
        //deskripsi = findViewById(R.id.tvDetailDeskripsi);
        btnMaps = findViewById(R.id.fbtnMaps);
        img = findViewById(R.id.imgDetailWisata);
        Intent i = getIntent();

        id_wisata = Integer.toString(i.getIntExtra("id_wisata", 0));
        String nama     = i.getStringExtra("nama_wisata");
        String alamt   = i.getStringExtra("alamat");
        dsk      = i.getStringExtra("deskripsi");
        String image    = i.getStringExtra("image");
        final Double lat      = i.getDoubleExtra("lt",0);
        final Double longi             = i.getDoubleExtra("lng",0);


        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(nama);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(getApplicationContext(),KategoriActivity.class);
//                startActivity(i);
                finish();
            }
        });

        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent maps = new Intent(getApplicationContext(),MapsActivity.class);
                maps.putExtra("lat",lat);
                maps.putExtra("longi",longi);

                startActivity(maps);
            }
        });


        if(getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nama_wisata.setText(nama);
        alamat.setText(alamt);
//        deskripsi.setText(dsk);
        Picasso.with(getApplicationContext())
                .load(ApiClient.BASE_URL+"assets/image/"+image)
                .into(img);



        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(DeskripsiFragment.newInstance(dsk), "Deskripsi");
        adapter.addFragment(KomentarFragment.newInstance(id_wisata), "Komentar");

        viewPager.setAdapter(adapter);
    }



}
