package com.example.myarbolito;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.myarbolito.DataSource.UsuarioDataSource;
import com.example.myarbolito.Modelo.Usuario;
import com.example.myarbolito.Repository.UsuarioRepository;
import com.example.myarbolito.Room.UsuarioRoomDataSource;
import com.example.myarbolito.Util.MyRoomDb;


public class FragmentRegistro extends Fragment {

  private Button registrar;
  private UsuarioRepository usuarioRepo;

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
        registrar= view.findViewById(R.id.registrar);
        aceptar();
    }

    public void aceptar(){
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usr= new Usuario();
                usr.setUsuario("Rpob");
                usr.setTelefono(12131313L);
                usr.setEmail("adfa@gmail.com");
                usuarioRepo = new UsuarioRepository( new UsuarioRoomDataSource (getContext()));
                usuarioRepo.saveUsuario(new UsuarioDataSource.GuardarUsuarioCallback() {
                    @Override
                    public void resultado(boolean exito) {
                        Toast.makeText(getContext(),"Se guardo",Toast.LENGTH_LONG).show();
                    }
               }, usr);





            }
        });


    }
}