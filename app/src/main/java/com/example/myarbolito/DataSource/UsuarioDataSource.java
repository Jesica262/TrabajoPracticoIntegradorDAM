package com.example.myarbolito.DataSource;


import com.example.myarbolito.Modelo.Usuario;

import java.util.List;

public interface UsuarioDataSource {
    interface GuardarUsuarioCallback {
        void resultado(final boolean exito);
    }

    interface RecuperarUsuarioCallback {
        void resultado(final boolean exito, final List<Usuario> usuarios);
    }

    void guardarUsuario(final Usuario usr, final GuardarUsuarioCallback callback);
    void recuperarUsuario(final RecuperarUsuarioCallback callback);


}
