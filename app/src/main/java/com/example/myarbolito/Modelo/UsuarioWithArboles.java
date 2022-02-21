package com.example.myarbolito.Modelo;


import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Relation;

import java.util.List;

@Entity
public class UsuarioWithArboles {
    @Embedded
    public Usuario usuario;
    @Relation(parentColumn = "arbolId",
               entityColumn= "userId" ,
               entity= Arbol.class)
    List<Arbol> arboles;

}