package com.example.myarbolito;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.myarbolito.DataSource.UsuarioDataSource;
import com.example.myarbolito.Modelo.Usuario;
import com.example.myarbolito.Repository.UsuarioRepository;
import com.example.myarbolito.Room.UsuarioRoomDataSource;

public class FragmentPerfil extends Fragment {
    private Usuario usr=null;
    private Button aceptar;
    private Bundle bundle;

    public FragmentPerfil( Bundle bundle) {
            if(bundle!=null)
               this.bundle=bundle;

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        aceptar = view.findViewById(R.id.registrar);

        bundle.getInt("id");
         Toast.makeText(getContext(),"id del usuario" +  bundle.getInt("id"),Toast.LENGTH_LONG).show();

        aceptar();
    }

    public void aceptar() {
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Menu.class);
                startActivity(intent);
            }
        });
    }
}