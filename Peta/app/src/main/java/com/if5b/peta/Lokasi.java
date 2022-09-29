package com.if5b.peta;

import com.google.android.gms.maps.model.LatLng;

public class Lokasi {
    private String nama;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    private LatLng latLng;




    public Lokasi(String nama, LatLng latLng) {

    }
}
