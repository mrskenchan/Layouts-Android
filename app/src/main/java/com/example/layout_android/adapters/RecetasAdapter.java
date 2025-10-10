package com.example.layout_android.adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.layout_android.R;
import com.example.layout_android.Receta;

import java.util.List;

public class RecetasAdapter extends RecyclerView.Adapter<RecetasAdapter.ViewHolder> {

    private List<Receta> recetas;

    public RecetasAdapter(List<Receta> recetas){
        this.recetas = recetas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receta, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Receta receta = recetas.get(position);
        holder.nombreReceta.setText(receta.getNombre());
        holder.preparacionReceta.setText(receta.getPreparacion());
    }

    @Override
    public int getItemCount(){
        return recetas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombreReceta;
        TextView preparacionReceta;

        public ViewHolder(View itemView){
            super(itemView);
            nombreReceta = itemView.findViewById(R.id.nombreReceta);
            preparacionReceta = itemView.findViewById(R.id.preparacionReceta);
        }
    }
}
