package com.example.myarbolito.DAO;

import static androidx.room.OnConflictStrategy.IGNORE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myarbolito.Modelo.Arbol;
import com.example.myarbolito.Modelo.Usuario;

import java.util.List;

@Dao
public interface DaoArbol {
    @Query("SELECT * FROM arbol")
    List<Arbol> getAll();

    /*@Query("Select * from arbol where  arbol.id=id ")
    Usuario getUsuario(Integer id );*/

    @Insert
    void insertAll(Arbol... arbols);

    @Insert(onConflict = IGNORE)
    Long insert(Arbol arbol);

    @Delete
    void delete(Usuario usuario);

}
