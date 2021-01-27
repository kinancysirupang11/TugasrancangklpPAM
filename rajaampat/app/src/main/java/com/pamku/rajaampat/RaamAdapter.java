package com.pamku.rajaampat;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RaamAdapter extends RecyclerView.Adapter<RaamAdapter.MyHolder>{
    List<RajaAmpat> RajaAmpat;


    public RaamAdapter(List<RajaAmpat> ListRA) {
        RajaAmpat = ListRA;
    }



    public class MyHolder extends RecyclerView.ViewHolder {
        public TextView Lok;
        public ImageView Gam;
        public MyHolder(View itemView) {
            super(itemView);
            Lok = (TextView) itemView.findViewById(R.id.Lokasi);
            Gam = (ImageView) itemView.findViewById(R.id.gambar);
        }
    }

    @Override
    public MyHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View parView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list, parent, false);
        MyHolder holder = new MyHolder(parView);
        return holder;
    }
    @Override
    public int getItemCount () {
        return RajaAmpat.size();
    }


    @Override
    public void onBindViewHolder (MyHolder holder, int position){
        holder.Lok.setText(RajaAmpat.get(position).getTitle());
        String G1 = RajaAmpat.get(position).getFoto();
        String G2 = String.valueOf(G1);
        Picasso.with(holder.itemView.getContext()).load(G2).into(holder.Gam);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Penjelasan.class);
                intent.putExtra("Tempat", RajaAmpat.get(position).getTitle());
                intent.putExtra("Lat", RajaAmpat.get(position).getLat());
                intent.putExtra("Lng", RajaAmpat.get(position).getLng());
                intent.putExtra("Foto", RajaAmpat.get(position).getFoto());
                intent.putExtra("Detail", RajaAmpat.get(position).getDeskripsi());
                view.getContext().startActivity(intent);
            }
        });
    }





}
