package com.example.myarbolito;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{


    private Toolbar toolbar;
    private TextView titulo;
    //private FragmentTransaction transaction;
    private Fragment fragmentRegistro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  toolbar = (Toolbar) findViewById(R.id.toolbar_drawer);
       // setSupportActionBar(toolbar);
        FragmentManager fragm =getSupportFragmentManager();
        FragmentMenu fragmentMenu=new FragmentMenu();
        fragm.beginTransaction().replace(R.id.contenido,fragmentMenu).addToBackStack(null).commit();

        //IniciarSesion();
        //MostrarInformacion();

  /*      registro = (Button) findViewById(R.id.registro);
        registro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch(view.getId())
                {
                    case R.id.registro:

                        break;
                    case R.id.inicio_sesion:

                        break;

                    case R.id.informacion:
                        break;
                }
            }
        });*/
    }



        //fragmentRegistro = new FragmentRegistro();

        //getSupportFragmentManager().beginTransaction().add(R.id.contenido,fragmentRegistro).commit();

        //Registrarse();
        //IniciarSesion();
        //MostrarInformacion();

        //transaction = getSupportFragmentManager().beginTransaction();

        //registro = (Button) findViewById(R.id.registro);

        //registro.setOnClickListener(new View.OnClickListener() {

        /*    @Override
            public void onClick(View view) {
                switch(view.getId())
                {
                    case R.id.registro:
                        transaction.replace(R.id.contenido, fragmentRegistro).commit();
                        transaction.addToBackStack(null);
                        break;
                    case R.id.inicio_sesion:

                        break;

                    case R.id.informacion:
                        break;
                }
            }
        });
    }
*/

}