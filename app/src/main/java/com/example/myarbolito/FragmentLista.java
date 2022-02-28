package com.example.myarbolito;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myarbolito.DataSource.ArbolDataSource;
import com.example.myarbolito.Modelo.Arbol;
import com.example.myarbolito.Modelo.UsuarioWithArboles;
import com.example.myarbolito.Repository.ArbolRepository;
import com.example.myarbolito.Room.ArbolRoomDataSource;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class FragmentLista extends Fragment {

    private RecyclerView recyclerView;
    private UsuarioWithArbolesViewHolder usuarioWithArbolesViewHolder;
    private List<UsuarioWithArboles> arbols;
    private TextView texviewArbol;
    private  ArbolRepository arbolRepo;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private FloatingActionButton floatingAdd;




    public FragmentLista() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setComponentes(view);
        initValues();
        agregarArbol();

    }

    private void setComponentes(View v) {

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerUsuarioWithArboles);
        texviewArbol = v.findViewById(R.id.textViewContenido);
        floatingAdd =v.findViewById(R.id.floatingAdd);

    }
    private void initValues() {

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        editor = sharedPreferences.edit();
        Integer  id=sharedPreferences.getInt("id",0);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);

            arbolRepo = new ArbolRepository(new ArbolRoomDataSource(getContext()));

            arbolRepo.traerArboles(new ArbolDataSource.RecuperarArbolesCallback() {
                @Override
                public void resultado(boolean exito, UsuarioWithArboles arbols) {
                    if(exito){
                        usuarioWithArbolesViewHolder = new UsuarioWithArbolesViewHolder( arbols);
                        recyclerView.setAdapter(usuarioWithArbolesViewHolder);
                              }
                    else{
                        Toast.makeText(getContext(),"No se encontraron arboles para este usuario",Toast.LENGTH_LONG).show();
                    }
                }
            }, id);


        }
        private void agregarArbol(){
        floatingAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragm = getActivity().getSupportFragmentManager();
                FragmentEleccionArbol fragmentEleccionArbol = new FragmentEleccionArbol();
                fragm.beginTransaction().replace(R.id.contenido, fragmentEleccionArbol).addToBackStack(null).commit();
                }
        });


        }


        }





