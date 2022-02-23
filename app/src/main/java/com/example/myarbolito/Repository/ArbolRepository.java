package com.example.myarbolito.Repository;

import com.example.myarbolito.DataSource.ArbolDataSource;
import com.example.myarbolito.DataSource.UsuarioDataSource;
import com.example.myarbolito.Modelo.Arbol;
import com.example.myarbolito.Modelo.Usuario;

import java.util.List;

public class ArbolRepository {
    private final ArbolDataSource datasource;



    public ArbolRepository(final ArbolDataSource datasource ) {
        this.datasource = datasource;
    }

    public void traerArboles(ArbolDataSource.RecuperarArbolesCallback callback ,Integer userId){

        Runnable r = new Runnable() {
            @Override
            public void run() {
                datasource.recuperarArboles(callback,userId);
            }
        };
        r.run();
    }
    public void saveArboles(ArbolDataSource.GuardarArbolCallback callback  , List<Arbol> arbols){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                datasource.guardarArbol(arbols,callback);
            }
        };
        r.run();
    }


}
