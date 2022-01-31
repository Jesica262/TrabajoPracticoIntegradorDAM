package com.example.myarbolito;



import android.content.Context;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import Model.Categoria;

public class Category{
    List<Categoria> categorias=new ArrayList<Categoria>();


    public List<Categoria> cargarCategoria(Context context) {
        List<Categoria> c = new ArrayList<Categoria>();

        c.add(new Categoria(
                        cat -> {
                            cat.setId("MLA5725");
                            cat.setNombreCategoria("Accesorios para Vehículos");
                            cat.setColor(ContextCompat.getColor((Context) context,R.color.md_amber_50));
                            cat.setIcon(R.drawable.baseline_filter_vintage_24);
                        }
                )
        );

    return c;
    }



}

