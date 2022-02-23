package com.example.myarbolito;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myarbolito.Modelo.Arbol;
import java.util.List;

public class FragmentEleccionArbol extends Fragment {

    private RecyclerView recyclerView;
    private ArbolViewHolder arbolViewHolder;
    private List<Arbol> arbols;
    private TextView texviewArbol;
    private Arbol seleccionadoArbol;

    public FragmentEleccionArbol() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eleccion_arbol, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setComponentes(view);
        initValues();
        seleccionItem();
    }

    private void setComponentes(View v) {

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerArbol);
        texviewArbol = v.findViewById(R.id.textViewContenido);
    }
    private void initValues() {

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        ArbolTipo arbolTipo = new ArbolTipo();
        arbols = arbolTipo.cargarArbol(getContext());
        arbolViewHolder = new ArbolViewHolder(arbols);
        recyclerView.setAdapter(arbolViewHolder);
    }

    public void seleccionItem() {
        arbolViewHolder.setonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                seleccionadoArbol= arbols.get(recyclerView.getChildAdapterPosition(v));
                Toast.makeText(getContext(), "Selecciono: " + arbols.get(recyclerView.getChildAdapterPosition(v)).getNombreArbol(), Toast.LENGTH_SHORT).show();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentPedirArbol fragmentPedirArbol= new FragmentPedirArbol(seleccionadoArbol);
                fragmentManager.beginTransaction().replace(R.id.contenido,fragmentPedirArbol).addToBackStack(null).commit();


            }
        });

    }
}