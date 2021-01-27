package com.pamku.rajaampat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Penjelasan extends AppCompatActivity {

    TextView nama, telepon, provinsi, deskripsi, lokasi;
    ImageView foto;
    String Lat, Lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjelasan);

        nama = (TextView) findViewById(R.id.nama);
        lokasi = findViewById(R.id.lokasi);
        deskripsi = findViewById(R.id.deskripsii);
        foto = findViewById(R.id.IMG);
        Intent intent = getIntent();
        String url2 = intent.getStringExtra("Foto");
        String uri3 = String.valueOf(url2);
        Picasso.with(this).load(uri3).into(foto);
        nama.setText(intent.getStringExtra("Tempat"));
        deskripsi.setText(intent.getStringExtra("Detail"));
        Lat = intent.getStringExtra("Lat");
        Lng = intent.getStringExtra("Lng");

        lokasi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V) {
                Intent A = new Intent(Penjelasan.this, Denah.class);
                A.putExtra("Lat", Lat);
                A.putExtra("Lng", Lng);
                A.putExtra("Title", intent.getStringExtra("Tempat"));
                V.getContext().startActivity(A);
            }

        });
    }
}
