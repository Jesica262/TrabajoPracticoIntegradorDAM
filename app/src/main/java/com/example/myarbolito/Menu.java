package com.example.myarbolito;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.widget.TextView;


import com.google.android.material.navigation.NavigationView;

public class Menu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        FragmentManager fragm =getSupportFragmentManager();
        FragmentInicio fragmentMenu=new FragmentInicio();
        fragm.beginTransaction().replace(R.id.contenido,fragmentMenu).addToBackStack(null).commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        drawer = findViewById(R.id.drawer_layout);
        setSupportActionBar(toolbar);
        navigationView= findViewById(R.id.nav_drawer);
        navigationView.setNavigationItemSelectedListener(this);
        toggle= new ActionBarDrawerToggle(this,drawer,toolbar,R.string.drawer_open,R.string.drawer_closed);
        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
    }
    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        selectItemNav(item);
        return true;
    }

    private void selectItemNav(@NonNull MenuItem item) {
        FragmentManager fragm =getSupportFragmentManager();
        TextView titulo= findViewById(R.id.titulo_toolbar);
        switch (item.getItemId()){

            case R.id.perfil:
                Bundle objetoRecibido = getIntent().getExtras();
                FragmentPerfil fragmentPerfil=new FragmentPerfil(objetoRecibido);
                fragm.beginTransaction().replace(R.id.contenido,fragmentPerfil).addToBackStack(null).commit();

                break;
            case R.id.listado:
                FragmentLista fragmentLista= new FragmentLista();
                fragm.beginTransaction().replace(R.id.contenido,fragmentLista).addToBackStack(null).commit();

                break;
            case R.id.informacion:
                FragmentInformacion fragmentInformacion= new FragmentInformacion();
                fragm.beginTransaction().replace(R.id.contenido,fragmentInformacion).addToBackStack(null).commit();
                break;
            case R.id.pedirArbol:
               // FragmentPedirArbol fragmentPedirArbol= new FragmentPedirArbol();
               // fragm.beginTransaction().replace(R.id.contenido,fragmentPedirArbol).addToBackStack(null).commit();
                FragmentEleccionArbol fragmentEleccionArbol= new FragmentEleccionArbol();
                fragm.beginTransaction().replace(R.id.contenido,fragmentEleccionArbol).addToBackStack(null).commit();
                break;
            case R.id.cerrar:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
        titulo.setText(item.getTitle());
        drawer.closeDrawers();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
}