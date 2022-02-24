package com.example.myarbolito.Modelo;


import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

@Entity
public class UsuarioWithArboles {
    @Embedded
    public Usuario usuario;
    @Relation(parentColumn = "userId",
                entityColumn= "userId" ,
                entity = Arbol.class)
   public List<Arbol> arboles;

}