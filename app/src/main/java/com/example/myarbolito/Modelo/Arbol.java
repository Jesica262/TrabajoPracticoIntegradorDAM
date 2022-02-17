package com.example.myarbolito.Modelo;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.android.gms.maps.GoogleMap;

@Entity(tableName = "arbol", foreignKeys = @ForeignKey(entity = Usuario.class,
        parentColumns = "userId",
        childColumns = "userId"))

public class Arbol {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private Integer arbolId;
    private String nombreArbol;
    private Integer userId;
    //private GoogleMap ubicacion;

    public Arbol() {
    }

    @NonNull
    public Integer getArbolId() {
        return arbolId;
    }

    public void setArbolId(@NonNull Integer arbolId) {
        this.arbolId = arbolId;
    }

    public String getNombreArbol() {
        return nombreArbol;
    }

    public void setNombreArbol(String nombreArbol) {
        this.nombreArbol = nombreArbol;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
