package com.intecap.libreriaherrera;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class FragmentoProducto extends Fragment {

    static RecyclerView.Adapter adaptador;
    RecyclerView.LayoutManager layoutManager;
    static RecyclerView rcvRecyclerProducto;
    static ArrayList<ModeloProductos> datos;



    public FragmentoProducto() {
        // Required empty public constructor
    }

    public static FragmentoProducto newInstance(String param1, String param2) {
        FragmentoProducto fragment = new FragmentoProducto();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragmento_producto, container,false);
        RecyclerView recyclerView = view.findViewById(R.id.rcvRecycleProductos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        rcvRecyclerProductos.setLayoutManager(layoutManager);

        datos = new ArrayList<ModeloProductos>();
        for(int i = 0; i < DatoProducto.nombreProductos.length; i++){
            datos.add(new ModeloProductos(DatoProducto.nombreProductos[i],DatoProducto.preciosProductos[i],DatoProducto.id[i], DatoProducto.imagenesArray[i]));
        }

        adaptador = new AdaptadorProducto(datos);
        recyclerView.setAdapter(adaptador);

        // Inflate the layout for this fragment
        return view;
    }
}