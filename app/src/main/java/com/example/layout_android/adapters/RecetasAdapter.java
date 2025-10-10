package com.example.layout_android.adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.layout_android.Receta;

import java.util.List;

public class RecetasAdapter extends RecyclerView.Adapter<RecetasAdapter.ViewHolder> {

    private List<Receta> recetas;

    public RecetasAdapter(List<Receta> recetas){
        this.recetas = recetas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Receta receta = recetas.get(position);
        holder.nombre.setText(receta.getNombre());
        holder.preparacion.setText(receta.getPreparacion());
    }

    @Override
    public int getItemCount(){
        return recetas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre;
        TextView preparacion;

        public ViewHolder(View itemView){
            super(itemView);
            nombre = itemView.findViewById(android.R.id.text1);
            preparacion = itemView.findViewById(android.R.id.text2);
        }
    }
}
