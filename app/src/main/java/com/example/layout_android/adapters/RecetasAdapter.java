package com.example.layout_android.adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ImageView;
import android.net.Uri;
import androidx.recyclerview.widget.RecyclerView;

import com.example.layout_android.R;
import com.example.layout_android.Receta;
import com.example.layout_android.DetalleRecetaActivity;

import java.util.List;

public class RecetasAdapter extends RecyclerView.Adapter<RecetasAdapter.ViewHolder> {

    private List<Receta> recetas;
    private OnRecetaActionListener listener;

    public RecetasAdapter(List<Receta> recetas, OnRecetaActionListener listener){
        this.recetas = recetas;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receta, parent, false);
        return new ViewHolder(view);
    }

    public interface OnRecetaActionListener { //separar logica de eliminar y modificar del adapter
        void onEditar (Receta receta, int position);
        void onEliminar (Receta receta, int position);
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

        holder.btnModificar.setOnClickListener(v ->{
            if (listener != null) listener.onEditar(receta, position);
        });

        holder.btnEliminar.setOnClickListener(v ->{
            if (listener != null) listener.onEliminar(receta, position);
        });

        holder.btnVerDetalles.setOnClickListener(v -> {
            android.content.Intent intent = new android.content.Intent(v.getContext(), DetalleRecetaActivity.class);
            intent.putExtra("nombre", receta.getNombre());
            intent.putExtra("preparacion", receta.getPreparacion());
            intent.putExtra("fotoRuta", receta.getFotoRuta());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount(){
        return recetas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombreReceta;
        TextView preparacionReceta;
        ImageView imagenReceta;
        android.widget.Button btnVerDetalles;
        ImageButton btnModificar;
        ImageButton btnEliminar;

        public ViewHolder(View itemView){
            super(itemView);
            nombreReceta = itemView.findViewById(R.id.nombreReceta);
            preparacionReceta = itemView.findViewById(R.id.preparacionReceta);
            imagenReceta = itemView.findViewById(R.id.imagenReceta);
            btnVerDetalles = itemView.findViewById(R.id.btnVerDetalles);
            btnModificar = itemView.findViewById(R.id.btn_modificar);
            btnEliminar = itemView.findViewById(R.id.btn_eliminar);
        }
    }

}
