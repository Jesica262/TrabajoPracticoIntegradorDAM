package com.example.myarbolito;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myarbolito.DataSource.ArbolDataSource;
import com.example.myarbolito.Modelo.Arbol;
import com.example.myarbolito.Modelo.Usuario;
import com.example.myarbolito.Modelo.UsuarioWithArboles;
import com.example.myarbolito.Repository.ArbolRepository;
import com.example.myarbolito.Room.ArbolRoomDataSource;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class FragmentPedirArbol extends Fragment  {

    private GoogleMap nMap;
    public List<LatLng> puntos;
    public List<MarkerOptions> marcadoresDeInteres;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public int contador = 0;
    private String name;
     private List<Arbol> arbols;
     private ArbolRepository arbolRepo;
     private Usuario usuario;


    private FloatingActionButton floatingAdd, floatingCheck;
    public Arbol arbol;

    public FragmentPedirArbol(Arbol arbol){
        this.arbol = arbol;

    }

    private OnMapReadyCallback callback = new OnMapReadyCallback(){

        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {

            nMap = googleMap;
            this.actualizarMapa();
            ejecutarActualizacionMapa();
            mostrarArbolesPrevios(nMap );

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
            LatLng SANTA_FE = new LatLng(-31.6370, -60.7269);
            nMap.moveCamera(CameraUpdateFactory.newLatLng(SANTA_FE));
            nMap.moveCamera(CameraUpdateFactory.zoomTo(12.0f));
            //LatLng sydney = new LatLng(-34, 151);
         //   nMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
          //  nMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            nMap.addMarker(new MarkerOptions().position(SANTA_FE).title("Santa Fe"));
            nMap.moveCamera(CameraUpdateFactory.newLatLng(SANTA_FE));
            nMap.setTrafficEnabled(true);
            nMap.setMyLocationEnabled(true);
            nMap.getUiSettings().setZoomControlsEnabled(true);

            nMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
                @Override
                public void onMapLongClick(@NonNull LatLng latLng) {
                    MarkerOptions o = new MarkerOptions()
                            .alpha(0.7f)
                            .draggable(true)
                            .position(latLng)
                            .title(arbol.getNombreArbol())
                            .icon(BitmapDescriptorFactory.fromResource(arbol.getIcon()))
                            .visible(true);
                    contador++;
                    marcadoresDeInteres.add(o);
                    nMap.addMarker(o);
                    Arbol a= new Arbol();
                    a.setUserId(usuario.getUserId());
                    a.setLat(latLng.latitude);
                    a.setLng(latLng.longitude);
                    a.setNombreArbol(arbol.getNombreArbol());
                    a.setIcon(arbol.getIcon());
                    a.setColor(arbol.getColor());
                    arbols.add(a);
                    if (latLng != SANTA_FE) {
                        puntos.add(latLng);
                    }
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
        initcomponentes(view);
        check();

    }

    private void mostrarArbolesPrevios(GoogleMap nM) {
        arbolRepo = new ArbolRepository(new ArbolRoomDataSource(getContext()));

        arbolRepo.traerArboles(new ArbolDataSource.RecuperarArbolesCallback() {
            @Override
            public void resultado(boolean exito, UsuarioWithArboles arbols) {
                if(exito){
                   for  (Arbol a: arbols.arboles){

                        LatLng latLng = new LatLng(a.getLat(),a.getLng());
                        nM.addMarker(new MarkerOptions()
                              .alpha(0.7f)
                              .draggable(true)
                              .position(latLng)
                              .title(a.getNombreArbol())
                              .icon(BitmapDescriptorFactory.fromResource(a.getIcon()))
                              .visible(true));
                       nM.animateCamera(CameraUpdateFactory.zoomTo(18.0f));
                       nM.moveCamera(CameraUpdateFactory.newLatLng(latLng));

                       }


                }

            }
        }, usuario.getUserId());



    }

    private void check() {

        editor = sharedPreferences.edit();
        editor.putInt("contador", contador);
        editor.commit();
        floatingCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     arbolRepo.saveArboles(new ArbolDataSource.GuardarArbolCallback() {
                    @Override
                    public void resultado(boolean exito) {
                        Toast.makeText(getContext(),"se guardaron",Toast.LENGTH_LONG).show();
                    }
                }, arbols);

              }


        });




    }


    private void initcomponentes(View view) {
        puntos = new ArrayList<LatLng>();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        name = sharedPreferences.getString("name", "");
        Integer  id=sharedPreferences.getInt("id",0);
        floatingAdd = view.findViewById(R.id.floatingAdd);
        floatingCheck = view.findViewById(R.id.floatingCheck);
        arbols= new ArrayList<Arbol>();
        usuario=new Usuario();
        usuario.setName(name);
        usuario.setUserId(id);
        usuario.setTelefono(sharedPreferences.getString("telefono",""));
        usuario.setEmail(sharedPreferences.getString("email",""));
        arbolRepo = new ArbolRepository(new ArbolRoomDataSource(getContext()));
    }
}