package com.example.myarbolito.DAO;

import static androidx.room.OnConflictStrategy.IGNORE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myarbolito.Modelo.Usuario;

import java.util.List;

@Dao
public interface DaoUsurio {

    @Query("SELECT * FROM usuario")
    List<Usuario> getAll();


   @Query("Select * from usuario  where  name= :nombre and pass=:pass ")
    Usuario getUsuario(String nombre ,String pass);

    @Insert
    void insertAll(Usuario... usuario);

    @Insert(onConflict = IGNORE)
    Long insert(Usuario usuario);

    @Delete
    void delete(Usuario usuario);
}
