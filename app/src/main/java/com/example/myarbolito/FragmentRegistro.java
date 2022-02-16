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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myarbolito.DataSource.UsuarioDataSource;
import com.example.myarbolito.Modelo.Usuario;
import com.example.myarbolito.Repository.UsuarioRepository;
import com.example.myarbolito.Room.UsuarioRoomDataSource;
import com.example.myarbolito.Util.MyRoomDb;


public class FragmentRegistro extends Fragment {

  private Button registrar;
  private UsuarioRepository usuarioRepo;
  private EditText usuarioEdt;
    private EditText pass;
    private EditText email;
    private EditText telefono;

    public FragmentRegistro() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registro, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        usuarioEdt =view.findViewById(R.id.nombre);
        pass= view.findViewById(R.id.password);
        email=view.findViewById(R.id.email);
        telefono=view.findViewById(R.id.telefono);
        registrar= view.findViewById(R.id.registrar);

        aceptar();
    }

    public void aceptar(){
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usr= new Usuario();
                usr.setName(usuarioEdt.getText().toString());
                usr.setPass(pass.getText().toString());
                usr.setEmail(email.getText().toString());
                usr.setTelefono(telefono.getText().toString());

                usuarioRepo = new UsuarioRepository( new UsuarioRoomDataSource (getContext()));
                usuarioRepo.saveUsuario(new UsuarioDataSource.GuardarUsuarioCallback() {
                    @Override
                    public void resultado(boolean exito) {
                        Toast.makeText(getContext(), "Usuario creado correctamente", Toast.LENGTH_LONG).show();

                    }
               }, usr);
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}