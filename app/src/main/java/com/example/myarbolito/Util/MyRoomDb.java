package com.example.myarbolito.Util;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myarbolito.DAO.DaoArbol;
import com.example.myarbolito.DAO.DaoUsurio;
import com.example.myarbolito.Modelo.Arbol;
import com.example.myarbolito.Modelo.Usuario;

@Database(entities = {Usuario.class, Arbol.class}, version = 2)
public abstract class MyRoomDb extends RoomDatabase {
    public abstract DaoArbol daoArbol();
    public abstract DaoUsurio daoUsurio();
    public static MyRoomDb INSTANCE;

    public static  MyRoomDb getInstance(Context ctx){
        if(INSTANCE==null) {
            INSTANCE = Room.databaseBuilder(ctx,MyRoomDb.class,"Db-TpFinal")
                    .allowMainThreadQueries()
                    //.fallbackToDestructiveMigration()
                    .build();
        }

        return INSTANCE;
    }
}
