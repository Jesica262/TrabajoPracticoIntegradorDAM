package com.example.myarbolito;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;


public class FragmentMenu extends Fragment {

    private Button registroMenu;
    private Button inicio_sesion;
    private Button informacionMenu;

    public FragmentMenu() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Toast.makeText(getContext(), "Hola", Toast.LENGTH_SHORT).show();
        setComponentes(view);
        Registrarse();
        IniciarSesion();
        MostrarInformacion();
    }

    private void setComponentes(View v) {
        registroMenu=(Button) v.findViewById(R.id.registroMenu);
        inicio_sesion=(Button) v.findViewById(R.id.inicio_sesion);
        informacionMenu=(Button) v.findViewById(R.id.informacionMenu);
    }
    public void Registrarse()
    {


        registroMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                FragmentManager fragm =getActivity().getSupportFragmentManager();
                FragmentRegistro fragmentRegistro= new FragmentRegistro();
                fragm.beginTransaction().replace(R.id.contenido,fragmentRegistro).addToBackStack(null).commit();
            }
        });
    }

    public void IniciarSesion()
    {

        inicio_sesion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                FragmentManager fragm =getActivity().getSupportFragmentManager();
                FragmentInicioSesion fragmentInicioSesion= new FragmentInicioSesion();
                fragm.beginTransaction().replace(R.id.contenido,fragmentInicioSesion).addToBackStack(null).commit();
            }
        });
    }

    public void MostrarInformacion()
    {



        informacionMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                FragmentManager fragm =getActivity().getSupportFragmentManager();
                FragmentInformacion fragmentInformacion= new FragmentInformacion();
                fragm.beginTransaction().replace(R.id.contenido,fragmentInformacion).addToBackStack(null).commit();
            }
        });
    }

}