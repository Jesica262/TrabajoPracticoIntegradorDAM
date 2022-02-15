package com.example.myarbolito.Repository;

import com.example.myarbolito.DataSource.UsuarioDataSource;
import com.example.myarbolito.Modelo.Usuario;

public class UsuarioRepository {
    private final UsuarioDataSource datasource;

    public UsuarioRepository(final UsuarioDataSource datasource) {
        this.datasource = datasource;
    }

    public void traerUsurios(UsuarioDataSource.RecuperarUsuarioCallback callback){

        Runnable r = new Runnable() {
            @Override
            public void run() {
                datasource.recuperarUsuario(callback);
            }
        };
        r.run();
    }
    public void saveUsuario(UsuarioDataSource.GuardarUsuarioCallback callback  ,Usuario usr){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                datasource.guardarUsuario(usr,callback);
            }
        };
        r.run();
    }

}
