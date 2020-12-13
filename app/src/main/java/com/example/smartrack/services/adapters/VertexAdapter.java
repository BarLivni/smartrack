package com.example.smartrack.services.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartrack.R;
import com.example.smartrack.models.Vertex;

import java.util.List;

public class VertexAdapter extends RecyclerView.Adapter<VertexAdapter.ViewHolder> {

    public List<Vertex> verticesList;
    public Context context;

    //constructor
    public VertexAdapter(List<Vertex> verticesList, Context context) {
        this.verticesList = verticesList;
        this.context = context;
    }

    //methods
    @NonNull
    @Override
    public VertexAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vertex_list_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VertexAdapter.ViewHolder holder, int position) {
        Vertex vertexRow=verticesList.get(position);

        holder.textViewCity.setText(vertexRow.city);
        holder.textViewAddress.setText(vertexRow.address);
        holder.textViewNumberItem.setText(vertexRow.itemsInVertex.size());
        holder.textViewZipcode.setText(vertexRow.zipcode);
    }

    @Override
    public int getItemCount() {
        return verticesList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewCity,textViewAddress,textViewNumberItem,textViewZipcode;
        public ImageView imageViewAdd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewCity=(TextView) itemView.findViewById(R.id.textViewCity);
            textViewAddress=(TextView) itemView.findViewById(R.id.textViewAddress);
            textViewNumberItem=(TextView) itemView.findViewById(R.id.textViewNumberItem);
            textViewZipcode=(TextView) itemView.findViewById(R.id.textViewZipcode);
            imageViewAdd=itemView.findViewById(R.id.imageViewAdd);
        }
    }




}
