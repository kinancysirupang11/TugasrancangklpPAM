package com.pamku.rajaampat;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiData {
    public static final String BASE_URL = "https://my-json-server.typicode.com/lanykinan/ampat/";
    private static Retrofit retrofit = null;
    public static Retrofit getList() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
