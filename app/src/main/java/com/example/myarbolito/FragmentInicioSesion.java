package com.example.myarbolito;

import android.app.AlarmManager;
import android.app.PendingIntent;
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
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.myarbolito.DataSource.ArbolDataSource;
import com.example.myarbolito.DataSource.UsuarioDataSource;
import com.example.myarbolito.Modelo.Usuario;
import com.example.myarbolito.Modelo.UsuarioWithArboles;
import com.example.myarbolito.Repository.ArbolRepository;
import com.example.myarbolito.Repository.UsuarioRepository;
import com.example.myarbolito.Room.ArbolRoomDataSource;
import com.example.myarbolito.Room.UsuarioRoomDataSource;

import java.util.Calendar;
import java.util.List;

public class FragmentInicioSesion extends Fragment {
    private UsuarioRepository usuarioRepo;
    private EditText usuarioEdt,passEdt;
    private Button aceptar;
    private Usuario usr;
    int CODIGO_DE_RESULTADO = 1;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private ArbolRepository arbolRepo;
    public static String  regar ="regar";



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
    private void regarArbolito() {


        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(getContext().ALARM_SERVICE);
        Intent intent = new Intent();
        Calendar calendar = Calendar.getInstance();
        intent.setAction(regar);
        intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),1000 * 60 * 30 , pendingIntent);

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
                            }
                        }
                    }
                });
                if(flag[0]) {
                    preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                    editor = preferences.edit();
                    arbolRepo = new ArbolRepository(new ArbolRoomDataSource(getContext()));
                    arbolRepo.traerArboles(new ArbolDataSource.RecuperarArbolesCallback() {
                        @Override
                        public void resultado(boolean exito, UsuarioWithArboles arbols) {
                            if(exito){
                               // editor.putInt("contador", arbols.arboles.size());
                                regarArbolito();
                            }
                            else
                                editor.putInt("contador", 0);
                        }
                    },usr.getUserId());

                    editor.putInt("id", usr.getUserId());
                    editor.putString("email", usr.getEmail());
                    editor.putString("telefono",usr.getTelefono());
                    editor.putString("name", usr.getName());
                    editor.commit();
                    Intent intent = new Intent(getContext(), Menu.class);
                    startActivity(intent);
        
                }
                else{
                    Toast.makeText(getContext(),"Usuario no valido, vuelva a ingresar",Toast.LENGTH_LONG).show();
                }

            }
        });
    }


}