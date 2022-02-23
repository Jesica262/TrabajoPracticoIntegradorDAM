package com.example.myarbolito.DataSource;

import com.example.myarbolito.Modelo.Arbol;
import com.example.myarbolito.Modelo.UsuarioWithArboles;

import java.util.List;

public interface ArbolDataSource {
    interface GuardarArbolCallback {
        void resultado(final boolean exito);
    }

    interface RecuperarArbolesCallback {
        void resultado(final boolean exito, UsuarioWithArboles arbols);
    }

    void guardarArbol(final List<Arbol> arbols, final ArbolDataSource.GuardarArbolCallback callback);
    void recuperarArboles(final ArbolDataSource.RecuperarArbolesCallback callback, Integer id);



}
