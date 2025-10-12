package com.example.layout_android.adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import android.net.Uri;
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

        // Manejo de la ruta de la imagen
        String ruta = receta.getFotoRuta();
        //if y else por si la imagen esta vacia o es nula
        if (ruta != null && !ruta.isEmpty()) {
            try {
                holder.imagenReceta.setImageURI(Uri.parse(ruta));
            } catch (Exception e) {
                // Fallback simple si hay un error con el Uri
                holder.imagenReceta.setImageResource(R.mipmap.ic_launcher);
            }
        } else {
            holder.imagenReceta.setImageResource(R.mipmap.ic_launcher);
        }
    }

    @Override
    public int getItemCount(){
        return recetas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombreReceta;
        TextView preparacionReceta;
        ImageView imagenReceta;

        public ViewHolder(View itemView){
            super(itemView);
            nombreReceta = itemView.findViewById(R.id.nombreReceta);
            preparacionReceta = itemView.findViewById(R.id.preparacionReceta);
            imagenReceta = itemView.findViewById(R.id.imagenReceta);
        }
    }
}
