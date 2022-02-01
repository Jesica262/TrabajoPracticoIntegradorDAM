package com.example.myarbolito;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

public class FragmentInicioSesion extends Fragment {

private Toolbar toolbar;
private TextView titulo;

    public FragmentInicioSesion() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_inicio_sesion, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
     //  toolbar=view.findViewById(R.id.toolbar_drawer);
         titulo=view.findViewById(R.id.titulo_toolbar);
        //titulo.setText(R.string.inicioSesion);

    }
}