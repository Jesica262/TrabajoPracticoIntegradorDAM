package com.example.myarbolito;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Model.Categoria;

public class MainActivity2 extends AppCompatActivity {


    private RecyclerView recyclerView;
    private CategoryViewHolder categoryViewHolder;
    private List<Categoria> categorias;
    private TextView texviewCategoria;
    private String seleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        init();
        initValues();
        seleccionItem();

    }


    private void init() {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerCategoria);
        texviewCategoria = findViewById(R.id.textViewContenido);
    }

    private void initValues() {

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        Category category = new Category();
        categorias = category.cargarCategoria(this);
        categoryViewHolder = new CategoryViewHolder(categorias);
        recyclerView.setAdapter(categoryViewHolder);


    }

    public void seleccionItem() {
        categoryViewHolder.setonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Selecciono: " + categorias.get(recyclerView.getChildAdapterPosition(v)).getNombreCategoria(), Toast.LENGTH_SHORT).show();
                seleccionado= categorias.get(recyclerView.getChildAdapterPosition(v)).getNombreCategoria();
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                intent.putExtra("Resultado",seleccionado);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }


}
