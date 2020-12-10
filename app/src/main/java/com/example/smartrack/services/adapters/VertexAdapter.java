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

public class VertexAdapter extends RecyclerView.Adapter<VertexAdapter.VertexViewHolder> {

    private Context mCtx;
    private List<Vertex> verticesList;

    // constructor
    public VertexAdapter(Context mCtx, List<Vertex> verticesList) {
        this.mCtx = mCtx;
        this.verticesList = verticesList;
    }

    @NonNull
    @Override
    public VertexViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        
    }

    @Override
    public void onBindViewHolder(@NonNull VertexViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return verticesList.size();
    }

    public class VertexViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewCity,textViewAddress,textViewNumberItem,textViewZipcode;
        public ImageView imageViewAdd;
        public VertexViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewCity=(TextView) itemView.findViewById(R.id.textViewCity);
            textViewAddress=(TextView) itemView.findViewById(R.id.textViewAddress);
            textViewNumberItem=(TextView) itemView.findViewById(R.id.textViewNumberItem);
            textViewZipcode=(TextView) itemView.findViewById(R.id.textViewZipcode);

            // set onclick listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

}
