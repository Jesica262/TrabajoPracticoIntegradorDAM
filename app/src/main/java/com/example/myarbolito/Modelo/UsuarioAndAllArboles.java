package com.example.myarbolito.Modelo;



import androidx.room.Relation;


import java.util.List;

public class UsuarioAndAllArboles {
    @Embbebed Usuario;
    @Relation(parentColumn = "id", entityColumn= "usuarioId" ,entity= Arbol.class)
    List<Arbol> arboles;

}
