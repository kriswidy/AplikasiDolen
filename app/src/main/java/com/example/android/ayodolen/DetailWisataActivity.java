package com.example.android.ayodolen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailWisataActivity extends AppCompatActivity {

    TextView nama_wisata, alamat, deskripsi;
    ImageView imgWisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

        nama_wisata = findViewById(R.id.tvDetailNama);
        alamat = findViewById(R.id.tvDetailAlamat);
        deskripsi = findViewById(R.id.tvDetailDeskripsi);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nama_wisata.setText("Pantai Clungup");
        alamat.setText("Sendang Biru, Area Sawah/Kebun, Tambakrejo, Sumbermanjing, Malang, Jawa Timur");
        deskripsi.setText("Pantai Clungup adalah sebuah pantai di pesisir selatan Pulau Jawa yang terletak di tepi Samudera Indonesia secara administratif berada di Desa Sitiarjo, Kecamatan Sumbermanjing Wetan, Kabupaten Malang, Jawa Timur.");

    }
}
