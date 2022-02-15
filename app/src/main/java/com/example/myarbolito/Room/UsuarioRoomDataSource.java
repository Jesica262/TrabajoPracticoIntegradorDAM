package com.example.myarbolito.Room;

import android.content.Context;

import androidx.room.OnConflictStrategy;


import com.example.myarbolito.DAO.DaoUsurio;
import com.example.myarbolito.DataSource.UsuarioDataSource;
import com.example.myarbolito.Modelo.Usuario;
import com.example.myarbolito.Util.MyRoomDb;

import java.util.List;

public class UsuarioRoomDataSource implements UsuarioDataSource {


    private MyRoomDb db;

    public UsuarioRoomDataSource(Context ctx){
        db= MyRoomDb.getInstance(ctx);
    };
    @Override
    public void guardarUsuario(Usuario usr, GuardarUsuarioCallback callback) {

        long filaInsert = db.daoUsurio().insert(usr);
        boolean result=false;
        if(filaInsert != OnConflictStrategy.IGNORE || filaInsert!= OnConflictStrategy.FAIL|| filaInsert != OnConflictStrategy.ABORT){
            result=true;
        }
        callback.resultado(result);
    }

    @Override
    public void recuperarUsuario(RecuperarUsuarioCallback callback) {
        List<Usuario> resultado = db.daoUsurio().getAll();
        boolean result= false;
        if(!resultado.isEmpty() || resultado!= null){
            result=true;
        }
        callback.resultado(result,resultado);
    }
}
