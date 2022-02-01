package com.example.myarbolito.Modelo;

import com.google.android.libraries.maps.GoogleMap;

public class Arbol {

    private Integer id;
    private String nombreArbol;
    private Usuario usuario;
    private GoogleMap ubicacion;

    public Arbol(){}

    public Arbol(Integer id, String nombreArbol, Usuario usuario, GoogleMap ubicacion) {
        this.id = id;
        this.nombreArbol = nombreArbol;
        this.usuario = usuario;
        this.ubicacion = ubicacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreArbol() {
        return nombreArbol;
    }

    public void setNombreArbol(String nombreArbol) {
        this.nombreArbol = nombreArbol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public GoogleMap getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(GoogleMap ubicacion) {
        this.ubicacion = ubicacion;
    }


}
