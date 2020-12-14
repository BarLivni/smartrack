package com.example.smartrack.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartrack.R;
import com.example.smartrack.models.Vertex;
import com.example.smartrack.services.adapters.VertexAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AddVertex extends AppCompatActivity {

    RecyclerView recyclerView;
    VertexAdapter vAdapter;   //RecyclerView.Adapter adapter;||Adapter adapter;

    List<Vertex> verticesList;
    DatabaseReference vertexRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vertex);

        recyclerView=findViewById(R.id.recyclerViewVertex);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        verticesList=new ArrayList<>();

        vertexRef= FirebaseDatabase.getInstance().getReference().child("Vertex");
        vertexRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren())
                {
                    Vertex v=dataSnapshot.getValue(Vertex.class);
                    verticesList.add(v);
                }
                vAdapter=new VertexAdapter(verticesList,AddVertex.this);
                recyclerView.setAdapter(vAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(AddVertex.this,"Oops... Could not read from Db",Toast.LENGTH_LONG).show();
            }
        });
    }


}