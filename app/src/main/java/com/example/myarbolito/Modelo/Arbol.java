package com.example.myarbolito.Modelo;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

import java.util.function.Consumer;

@Entity(tableName = "arbol", foreignKeys = @ForeignKey(entity = Usuario.class,
        parentColumns = "userId",
        childColumns = "userId"))

public class Arbol {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private Integer arbolId;
    private String nombreArbol;
    private int icon;
    private int color;
    private Integer userId;
    private double lat ;
    private double lng ;

    public Arbol() {
    }
    public  Arbol(Consumer<Arbol> c){
        c.accept(this);
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
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
