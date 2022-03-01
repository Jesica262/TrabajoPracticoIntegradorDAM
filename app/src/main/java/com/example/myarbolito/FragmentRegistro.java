package com.example.myarbolito;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myarbolito.DataSource.UsuarioDataSource;
import com.example.myarbolito.Modelo.Usuario;
import com.example.myarbolito.Repository.UsuarioRepository;
import com.example.myarbolito.Room.UsuarioRoomDataSource;

import java.util.Calendar;


public class FragmentRegistro extends Fragment {

  private Button registrar;
  private UsuarioRepository usuarioRepo;
  private EditText usuarioEdt;
   private EditText pass;
    private EditText email;
    private EditText telefono;
    public static String  noti ="com.example.myarbolito";

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
                if (validar()==1) {

                    Usuario usr = new Usuario();
                    usr.setName(usuarioEdt.getText().toString());
                    usr.setPass(pass.getText().toString());
                    usr.setEmail(email.getText().toString());
                    usr.setTelefono(telefono.getText().toString());

                    usuarioRepo = new UsuarioRepository(new UsuarioRoomDataSource(getContext()));
                    usuarioRepo.saveUsuario(new UsuarioDataSource.GuardarUsuarioCallback() {
                        @Override
                        public void resultado(boolean exito) {
                            Toast.makeText(getContext(), "Usuario creado correctamente", Toast.LENGTH_LONG).show();

                        }
                    }, usr);

                    mensajeBienvenida();
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                }


            }

            private void mensajeBienvenida() {
                AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(getContext().ALARM_SERVICE);
                Intent intent = new Intent();
                intent.setAction(noti);
                intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, Calendar.getInstance().getTimeInMillis(), pendingIntent);
            }


        });
    }

    private Integer validar() {
        int flag = 0;
        if (usuarioEdt.getText().toString().equals(""))
            usuarioEdt.setError("Introduzca su nombre");
        else {
            if (pass.getText().toString().equals(""))
                pass.setError("Introduzca una contraseña");
            else {
                if (email.getText().toString().equals(""))
                    email.setError("Introduzca su email");
                else {
                    if (telefono.getText().toString().equals(""))
                        telefono.setError("Introduzca su telefono");
                    else {
                        flag=1;

                    }

                }
            }
        }

    return flag;
    }
}