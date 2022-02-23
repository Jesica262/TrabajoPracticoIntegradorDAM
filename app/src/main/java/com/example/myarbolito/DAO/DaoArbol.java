package com.example.myarbolito.DAO;

import static androidx.room.OnConflictStrategy.IGNORE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myarbolito.Modelo.Arbol;
import com.example.myarbolito.Modelo.Usuario;
import com.example.myarbolito.Modelo.UsuarioWithArboles;

import java.util.List;

@Dao
public interface DaoArbol {
    @Query("SELECT * FROM arbol")
    List<Arbol> getAll();

    @Query("Select * from arbol  where  userId= :u")
    List<UsuarioWithArboles> getArboles(Integer u);

    @Insert ( onConflict = OnConflictStrategy.REPLACE )
    List<Long> insertAll(Arbol... arbols);

    @Insert(onConflict = IGNORE)
    Long insert(Arbol arbol);

    @Delete
    void delete(Arbol arbol);


}
