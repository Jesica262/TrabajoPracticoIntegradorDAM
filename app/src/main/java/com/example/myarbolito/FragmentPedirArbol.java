package com.example.myarbolito;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class FragmentPedirArbol extends Fragment  {

    private GoogleMap nMap;
    public List<LatLng> puntos;
    public List<MarkerOptions> marcadoresDeInteres;
    public int contador=0;

    public FragmentPedirArbol(){}

    private OnMapReadyCallback callback = new OnMapReadyCallback(){

        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {

            nMap = googleMap;

            this.actualizarMapa();
            ejecutarActualizacionMapa();

        }

        private void actualizarMapa() {

            if(ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(getActivity(), new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION}, 9999);
                return;
                }
        }

        public Boolean noTienePermisoAcceso()
        {
            return ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED;
        }

        @SuppressLint("MissingPermission")
        public void ejecutarActualizacionMapa()
        {
            marcadoresDeInteres = new ArrayList<>();
            puntos = new ArrayList<>();
           // LatLng SANTA_FE = new LatLng(-31.6370, -60.7269);
           // nMap.moveCamera(CameraUpdateFactory.newLatLng(SANTA_FE));
           // nMap.moveCamera(CameraUpdateFactory.zoomTo(12.0f));
            LatLng sydney = new LatLng(-34, 151);
            nMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            nMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            nMap.setTrafficEnabled(true);
            nMap.setMyLocationEnabled(true);
            nMap.getUiSettings().setZoomControlsEnabled(true);
            nMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(@NonNull LatLng latLng) {
                    puntos.add(latLng);
                }
            });
            nMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
                @Override
                public void onMapLongClick(@NonNull LatLng latLng) {
                    MarkerOptions o = new MarkerOptions()
                            .alpha(0.7f)
                            .snippet("Hola"+(++contador))
                            .draggable(true)
                            .position(latLng)
                            .title("NOMBRE"+contador)
                            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_arbol))
                            .visible(true);
                    marcadoresDeInteres.add(o);
                    nMap.addMarker(o);
                }
            });
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=  inflater.inflate(R.layout.fragment_maps, container, false);
        return view; }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}