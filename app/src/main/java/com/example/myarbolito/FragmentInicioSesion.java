package com.example.myarbolito;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.myarbolito.DataSource.UsuarioDataSource;
import com.example.myarbolito.Modelo.Usuario;
import com.example.myarbolito.Repository.UsuarioRepository;
import com.example.myarbolito.Room.UsuarioRoomDataSource;

public class FragmentInicioSesion extends Fragment {

    private Button aceptar;

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

        aceptar = view.findViewById(R.id.aceptar);
        aceptar();
    }
    public void aceptar(){
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), Menu.class);
                startActivity(intent);
            }
        });
    }
}