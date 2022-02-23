package com.example.myarbolito.Room;

import android.content.Context;

import androidx.room.OnConflictStrategy;

import com.example.myarbolito.DataSource.ArbolDataSource;
import com.example.myarbolito.Modelo.Arbol;
import com.example.myarbolito.Modelo.UsuarioWithArboles;
import com.example.myarbolito.Util.MyRoomDb;

import java.util.List;

public class ArbolRoomDataSource implements ArbolDataSource {

    private MyRoomDb db;

    public ArbolRoomDataSource(Context context) {
        db=MyRoomDb.getInstance(context);
    }


    @Override
    public void guardarArbol(List<Arbol> arbols, GuardarArbolCallback callback) {
        try {
            boolean result=false;
            for(Arbol a : arbols){
                Long filaInsert = db.daoArbol().insert(a);
                if(filaInsert != OnConflictStrategy.IGNORE || filaInsert!= OnConflictStrategy.FAIL|| filaInsert != OnConflictStrategy.ABORT){
                    result=true;
                }

            }

            callback.resultado(result);

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void recuperarArboles(RecuperarArbolesCallback callback, Integer userId) {
      List<UsuarioWithArboles> arbols= db.daoArbol().getArboles(userId);
        boolean result= false;
        if(!arbols.isEmpty() || arbols!= null){
            result=true;
        }
        callback.resultado(result,arbols);
    }

}

