package com.pamku.rajaampat;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiGet {
    @GET("ampat")
    Call<ArrayList<RajaAmpat>> GetAllDataRA();
}
