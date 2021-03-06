package com.example.myarbolito;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.myarbolito.Modelo.Usuario;

public class FragmentPerfil extends Fragment {

    private Button aceptar;
    private EditText identificacion, email, telefono, nombreEdit;
    private SharedPreferences preferences;

    public FragmentPerfil() { }

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
        mostrarDatos();
        aceptar();
    }

    private void mostrarDatos()  {
        Integer id=preferences.getInt("id",0);
        identificacion.setText(id.toString());
        email.setText(preferences.getString("email","email"));
        telefono.setText(preferences.getString("telefono","telefono"));
        nombreEdit.setText(preferences.getString("name","nombre"));

    }

    private void init(View view) {
        aceptar = view.findViewById(R.id.registrar);
        identificacion = view.findViewById(R.id.identificadorPerfil);
        email = view.findViewById(R.id.emailTextPerfil);
        telefono = view.findViewById(R.id.telefonoPerfil);
        nombreEdit = view.findViewById(R.id.nombreEdit);
        preferences = PreferenceManager.getDefaultSharedPreferences(getContext());

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