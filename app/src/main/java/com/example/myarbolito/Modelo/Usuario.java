package com.example.myarbolito.Modelo;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
@Entity(tableName = "usuario")
public class Usuario {
      @PrimaryKey(autoGenerate = true)
      @NonNull
      private Integer id;
      private String usuario;
      private String pass;
      private String email;
      private Long telefono;
      //private List<Arbol> arboles;

      public Usuario(){}

   /* public Usuario(Integer id, String usuario, String pass, String email, Long telefono, List<Arbol> arboles) {
        this.id = id;
        this.usuario = usuario;
        this.pass = pass;
        this.email = email;
        this.telefono = telefono;
        this.arboles = arboles;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

  /*  public List<Arbol> getArboles() {
        return arboles;
    }*/

  /* public void setArboles(List<Arbol> arboles) {
        this.arboles = arboles;
    }*/
}
