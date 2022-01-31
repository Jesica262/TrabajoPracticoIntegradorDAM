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

    private Button registro;
    private Button inicio_sesion;
    private Button informacion;
    private Toolbar toolbar;
    private TextView titulo;
    private FragmentTransaction transaction;
    private Fragment fragmentRegistro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragm =getSupportFragmentManager();
        FragmentMenu fragmentMenu=new FragmentMenu();
        fragm.beginTransaction().replace(R.id.contenidoMenu,fragmentMenu).addToBackStack(null).commit();

        transaction = getSupportFragmentManager().beginTransaction();
        registro = (Button) findViewById(R.id.registro);
        registro.setOnClickListener(new View.OnClickListener() {

            @Override
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
      //  Registrarse();
      //  IniciarSesion();
      //  MostrarInformacion();


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
    public void Registrarse()
    {
        registro = (Button) findViewById(R.id.registro);

        registro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                FragmentManager fragm =getSupportFragmentManager();
                FragmentRegistro fragmentRegistro= new FragmentRegistro();
                fragm.beginTransaction().replace(R.id.contenidoMenu,fragmentRegistro).addToBackStack(null).commit();
            }
        });
    }

    public void IniciarSesion()
    {
        inicio_sesion = (Button) findViewById(R.id.inicio_sesion);

        inicio_sesion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                FragmentManager fragm =getSupportFragmentManager();
                FragmentInicioSesion fragmentInicioSesion= new FragmentInicioSesion();
                fragm.beginTransaction().replace(R.id.contenidoMenu,fragmentInicioSesion).addToBackStack(null).commit();
            }
        });
    }

    public void MostrarInformacion()
    {
        informacion = (Button) findViewById(R.id.informacion);

        informacion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                FragmentManager fragm =getSupportFragmentManager();
                FragmentInformacion fragmentInformacion= new FragmentInformacion();
                fragm.beginTransaction().replace(R.id.contenidoMenu,fragmentInformacion).addToBackStack(null).commit();
            }
        });
    }
}