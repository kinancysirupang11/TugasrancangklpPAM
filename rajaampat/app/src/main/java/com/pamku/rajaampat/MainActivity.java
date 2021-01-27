package com.pamku.rajaampat;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {
    private ApiGet GetApi;
    private RecyclerView RView;
    private RecyclerView.Adapter RAdapter;
    private RecyclerView.LayoutManager LManager;
    public static MainActivity utama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RView = (RecyclerView) findViewById(R.id.list);


        LManager = new LinearLayoutManager(this);
        RView.setLayoutManager(LManager);
        GetApi = ApiData.getList().create(ApiGet.class);
        utama=this;


        Call<ArrayList<RajaAmpat>> ListKu = GetApi.GetAllDataRA();
        ListKu.enqueue(new Callback<ArrayList<RajaAmpat>>() {
            @Override
            public void onResponse(Call<ArrayList<RajaAmpat>> call, Response<ArrayList<RajaAmpat>>
                    response) {
                ArrayList<RajaAmpat> List = response.body();
                RAdapter = new RaamAdapter(List);
                RView.setAdapter(RAdapter);

            }

            @Override
            public void onFailure(Call<ArrayList<RajaAmpat>> call, Throwable t) {
                Log.e("Fail", t.toString());
            }
        });
    }
}
