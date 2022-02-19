package com.example.myarbolito;

import android.content.Context;
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

import org.json.JSONException;

import java.util.Objects;

public class FragmentPerfil extends Fragment {
    private Usuario usr ;
    private Button aceptar;
    private Bundle bundle;
    private EditText identificacion, email, telefono,nombreUsr;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private String key="usuario";

    public FragmentPerfil(Bundle bundle) {
        this.bundle = bundle;
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

    private void setCampos()  {
        if (bundle != null) {

            usr.setUserId(bundle.getInt("id"));
            usr.setName(bundle.getString("name"));
            usr.setEmail(bundle.getString("email"));
            usr.setTelefono(bundle.getString("telefono"));
            editor.putString("id",usr.getUserId().toString());
            editor.putString("email", usr.getEmail());
            editor.putString("telefono",usr.getTelefono());
            editor.putString("name", usr.getName());
            editor.commit();
            mostrarDatos();

        } else {
            mostrarDatos();

        }
    }

    private void mostrarDatos()  {
        identificacion.setText(preferences.getString("id","id"));
        email.setText(preferences.getString("email","email"));
        telefono.setText(preferences.getString("telefono","telefono"));
        nombreUsr.setText(preferences.getString("name","nombre"));

    }

    private void init(View view) {
        aceptar = view.findViewById(R.id.registrar);
        identificacion = view.findViewById(R.id.identificadorPerfil);
        email = view.findViewById(R.id.emailTextPerfil);
        nombreUsr=view.findViewById(R.id.nombreUsr);
        telefono = view.findViewById(R.id.telefonoPerfil);
        preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        editor = preferences.edit();
        usr=new Usuario();

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