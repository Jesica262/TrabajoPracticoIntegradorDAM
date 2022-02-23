package com.example.myarbolito;

import android.content.Context;

import androidx.core.content.ContextCompat;

import com.example.myarbolito.Modelo.Arbol;
import java.util.ArrayList;
import java.util.List;

public class ArbolTipo {

    public List<Arbol> cargarArbol(Context context) {

        List<Arbol> c = new ArrayList<Arbol>();
        c.add(new Arbol(
            arbol -> {

                arbol.setNombreArbol("Algarrobo negro");
                arbol.setColor(ContextCompat.getColor((Context) context,R.color.md_green_300));
                arbol.setIcon(R.mipmap.ic_arbol);
            }
        ));
      c.add(new Arbol(
                arbol -> {

                    arbol.setNombreArbol("Palo borracho");
                    arbol.setColor(ContextCompat.getColor((Context) context,R.color.md_green_600));
                    arbol.setIcon(R.mipmap.ic_arbol2);
                }
        ));
        c.add(new Arbol(
                arbol -> {

                    arbol.setNombreArbol("Quebracho blanco");
                    arbol.setColor(ContextCompat.getColor((Context) context,R.color.md_green_300));
                    arbol.setIcon(R.mipmap.ic_arbol3);
                }
        ));
        c.add(new Arbol(
                arbol -> {

                    arbol.setNombreArbol("Aromo");
                    arbol.setColor(ContextCompat.getColor((Context) context,R.color.md_green_600));
                    arbol.setIcon(R.mipmap.ic_arbol4);
                }
        ));
      c.add(new Arbol(
                arbol -> {

                    arbol.setNombreArbol("Ciruelo de flor");
                    arbol.setColor(ContextCompat.getColor((Context) context,R.color.md_green_300));
                    arbol.setIcon(R.mipmap.ic_arbol6);
                }
        ));
        c.add(new Arbol(
                arbol -> {

                    arbol.setNombreArbol("Fresno american");
                    arbol.setColor(ContextCompat.getColor((Context) context,R.color.md_green_600));
                    arbol.setIcon(R.mipmap.ic_arbol7);
                }
        ));
       c.add(new Arbol(
                arbol -> {

                    arbol.setNombreArbol("Hovenia");
                    arbol.setColor(ContextCompat.getColor((Context) context,R.color.md_green_300));
                    arbol.setIcon(R.mipmap.ic_arbol8);
                }
        ));
        c.add(new Arbol(
                arbol -> {

                    arbol.setNombreArbol("Roble europeo");
                    arbol.setColor(ContextCompat.getColor((Context) context,R.color.md_green_600));
                    arbol.setIcon(R.mipmap.ic_arbol9);
                }
        ));
        c.add(new Arbol(
                arbol -> {

                    arbol.setNombreArbol("Roble de los pantanos");
                    arbol.setColor(ContextCompat.getColor((Context) context,R.color.md_green_300));
                    arbol.setIcon(R.mipmap.ic_arbol10);
                }
        ));
        c.add(new Arbol(
                arbol -> {

                    arbol.setNombreArbol("Hovenia");
                    arbol.setColor(ContextCompat.getColor((Context) context,R.color.md_green_600));
                    arbol.setIcon(R.mipmap.ic_arbol11);
                }
        ));
    return c;
    }
}