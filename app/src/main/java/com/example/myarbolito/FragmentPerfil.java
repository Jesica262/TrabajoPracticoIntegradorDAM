package com.example.myarbolito;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myarbolito.DataSource.UsuarioDataSource;
import com.example.myarbolito.Modelo.Usuario;
import com.example.myarbolito.Repository.UsuarioRepository;
import com.example.myarbolito.Room.UsuarioRoomDataSource;

public class FragmentPerfil extends Fragment {
    private Usuario usr=null;
    private Button aceptar;
    private Bundle bundle;
    private EditText identificacion, email, telefono;
    private SharedPreferences sp;

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
        init(view);
        setCampos();
        aceptar();
    }

    private void setCampos() {
        identificacion.setText(""+bundle.getInt("id"));
        email.setText(""+bundle.getString("email") );
        telefono.setText(""+bundle.getString("telefono"));
    }

    private void init(View view) {
        aceptar = view.findViewById(R.id.registrar);
        identificacion=view.findViewById(R.id.identificadorPerfil);
        email=view.findViewById(R.id.emailTextPerfil);
        telefono=view.findViewById(R.id.telefonoPerfil);
        sp= PreferenceManager.getDefaultSharedPreferences(getContext());
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