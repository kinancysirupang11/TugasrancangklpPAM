package com.pamku.rajaampat;

import com.google.gson.annotations.SerializedName;

public class RajaAmpat {
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("lat")
    private String lat;
    @SerializedName("lng")
    private String lng;
    @SerializedName("foto")
    private String foto;
    @SerializedName("deskripsi")
    private String deskripsi;

    public RajaAmpat(String id, String title, String lat, String lng, String foto, String deskripsi) {
        this.id = id;
        this.title = title;
        this.lat = lat;
        this.lng = lng;
        this.foto = foto;
        this.deskripsi = deskripsi;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getFoto() {
        return foto;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
}
