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
import android.widget.Toolbar;

import com.example.myarbolito.DataSource.UsuarioDataSource;
import com.example.myarbolito.Modelo.Usuario;
import com.example.myarbolito.Repository.UsuarioRepository;
import com.example.myarbolito.Room.UsuarioRoomDataSource;

import java.util.List;

public class FragmentInicioSesion extends Fragment {
    private UsuarioRepository usuarioRepo;
    private EditText usuarioEdt,passEdt;
    private Button aceptar;
    private Usuario usr;
    int CODIGO_DE_RESULTADO = 1;
    private Bundle bundle;

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
        usuarioEdt= view.findViewById( R.id.nombreInicioSesion);
        passEdt=view.findViewById(R.id.passwordInicioSesion);
        aceptar = view.findViewById(R.id.aceptar);
        aceptar();
    }
    public void aceptar(){

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final boolean[] flag = {false};
                usuarioRepo = new UsuarioRepository( new UsuarioRoomDataSource (getContext()));
                usuarioRepo.traerUsurios(new UsuarioDataSource.RecuperarUsuarioCallback() {
                    @Override
                    public void resultado(boolean exito, List<Usuario> usuarios) {

                              for(Usuario u: usuarios){
                                  if(u.getName().equals(usuarioEdt.getText().toString()) && u.getPass().equals(passEdt.getText().toString()) ){
                                      Toast.makeText(getContext(),"Usuario Autenticado",Toast.LENGTH_LONG).show();
                                      flag[0] =true;
                                      usr= new Usuario();
                                      usr.setUserId(u.getUserId());
                                      usr.setName(u.getName());
                                     // usr.setPass(u.getPass());
                                      usr.setTelefono(u.getTelefono());
                                      usr.setEmail(u.getEmail());
                                      break;
                                  }
                              }
                    }
                });
                if(flag[0]){
                    Intent intent = new Intent(getContext(), Menu.class);
                    bundle=new Bundle();
                    bundle.putInt("id",usr.getUserId());
                    bundle.putString("nombre",usr.getName());
                    bundle.putString("email",usr.getEmail());
                    bundle.putString("telefono",usr.getTelefono());
                    intent.putExtras(bundle);
                    startActivity( intent);
        
                }
                else{
                    Toast.makeText(getContext(),"Usuario no valido, vuelva a ingresar",Toast.LENGTH_LONG).show();
                }

            }
        });
    }


}