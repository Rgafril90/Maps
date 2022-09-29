package com.if5b.peta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.if5b.peta.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private ActivityMainBinding binding;
    private GoogleMap mMap;
    private List<Lokasi> restaurantlist = new ArrayList<>() ;
    private List<Lokasi> hospitallist = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        set
        restaurantlist.add(new Lokasi("RM Bundo Kandung", new LatLng(-2.962086529592275, 104.73996121226467)));
        restaurantlist.add(new Lokasi("Rumah Makan Tuyul Wira Bopeng ", new LatLng(-2.961673559717251, 104.73751794044264)));
        restaurantlist.add(new Lokasi("RUMAH MAKAN AGUNG SALERO KAMPUNG", new LatLng(-2.9619307078208337, 104.73733555022015)));
        restaurantlist.add(new Lokasi("Pondok Ayam Bakar & Bakso Solo \"Mas Tarjo\"", new LatLng(-2.9613628390124225, 104.73763595764542)));
        restaurantlist.add(new Lokasi("RM Pondok Kelapo", new LatLng(-2.96351645315789, 104.73585497100579)));
        restaurantlist.add(new Lokasi("RUMAH MAKAN SAMUDRA RAYA ", new LatLng(-2.9628414402254273, 104.73377357670229)));


        hospitallist.add(new Lokasi("Rumah Sakit Bunda Palembang", new LatLng(-2.9668844504021274, 104.7347135265285)));
        hospitallist.add(new Lokasi("Rumah Sakit Umum Sriwijaya Palembang", new LatLng(-2.959220868602933, 104.73695115592975)));
        hospitallist.add(new Lokasi("Rumah Sakit Bersalin Aryodila", new LatLng(-2.96422649541929, 104.73923106640216)));
        hospitallist.add(new Lokasi("Rumah Sakit Bhayangkara", new LatLng(-2.9583692145668037, 104.73743846503834)));
        hospitallist.add(new Lokasi("Rsu Bunda", new LatLng(-2.966686733464006, 104.73425916497146)));




        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

//        binding restaularant
        binding.fabRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.clear();

                for (int i = 0 ; i < restaurantlist.size(); i++) {
                    mMap.addMarker(new MarkerOptions()
                            .position(restaurantlist.get(i).getLatLng())
                            .title(restaurantlist.get(i).getNama())
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
                            .showInfoWindow();
                }

                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(restaurantlist.get(4).getLatLng(),4));
            }
        });

//        binding Hospital
        binding.fabHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.clear();

                for (int i = 0 ; i < hospitallist.size(); i++) {
                    mMap.addMarker(new MarkerOptions()
                                    .position(hospitallist.get(i).getLatLng())
                                    .title(hospitallist.get(i).getNama())
                                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
                                    .showInfoWindow();
                }

                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(hospitallist.get(1).getLatLng(),15));
            }
        });

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
//        mMap.setMyLocationEnabled(true);
        LatLng latLngUser = new LatLng(-2.973424, 104.764064);
        mMap.addMarker(new MarkerOptions().position(latLngUser).title("Lokasi Saya"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLngUser, 19));
    }
}