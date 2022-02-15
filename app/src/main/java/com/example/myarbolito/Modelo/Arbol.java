package com.example.myarbolito.Modelo;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.android.gms.maps.GoogleMap;

/*@Entity (tableName = "arbol",foreignKeys = @ForeignKey(entity =Usuario.class,
                                                        parentColumns = "id",
                                                        childColumns = "user_id"))
*/
@Entity (tableName = "arbol")
public class Arbol {
    @PrimaryKey
    @NonNull
    private Integer id;
    private String nombreArbol;
  //  @ColumnInfo(name = "user_id")
 //   private Integer userId;
   // private GoogleMap ubicacion;

    public Arbol(){}

 /*   public Arbol(Integer id, String nombreArbol, Usuario usuario, GoogleMap ubicacion) {
        this.id = id;
        this.nombreArbol = nombreArbol;
        this.usuario = usuario;
        this.ubicacion = ubicacion;
    }*/

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

   /* public Usuario getUsuario() {
        return usuario;
    }*/

  /* public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }*/

 /*   public GoogleMap getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(GoogleMap ubicacion) {
        this.ubicacion = ubicacion;
    }*/


}
