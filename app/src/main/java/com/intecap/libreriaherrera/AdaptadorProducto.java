package com.intecap.libreriaherrera;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorProducto extends RecyclerView.Adapter<AdaptadorProducto.MiViewHolder>{

    ArrayList<ModeloProductos> datos;

    public AdaptadorProducto(ArrayList<ModeloProductos> datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public AdaptadorProducto.MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false );

        MiViewHolder viewHolder = new MiViewHolder(vista);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorProducto.MiViewHolder holder, int position) {
        TextView txtNombre = holder.txtModelo;
        TextView txtPrecio = holder.txtPrecio;
        ImageView imgView = holder.imgImagen;


        txtNombre.setText(datos.get(position).getNombre());
        txtPrecio.setText(datos.get(position).getPrecio());
        imgView.setImageResource(datos.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public class MiViewHolder extends RecyclerView.ViewHolder{

        TextView txtModelo;
        TextView txtPrecio;
        ImageView imgImagen;

        public MiViewHolder(@NonNull View itemView) {
            super(itemView);

            this.txtModelo = itemView.findViewById(R.id.txtNombre);
            this.txtPrecio = itemView.findViewById(R.id.txtPrecio);
            this.imgImagen = itemView.findViewById(R.id.imgImagenProducto);
        }
    }
}
