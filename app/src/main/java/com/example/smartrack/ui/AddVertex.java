package com.example.smartrack.ui;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import com.example.smartrack.R;
import com.example.smartrack.models.Globals;
import com.example.smartrack.models.Graph;
import com.google.android.material.navigation.NavigationView;

public class AddVertex extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navView;
    RecyclerView verticesList;
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vertex);

        // set Globals
        ((Globals) this.getApplication()).setVertexCounter(0);
        ((Globals) this.getApplication()).setEdgeCounter(0);
        ((Globals) this.getApplication()).setItemCounter(0);

        // get Globals
        int vertexCounter = ((Globals) this.getApplication()).getVertexCounter();
        int edgeCounter = ((Globals) this.getApplication()).getEdgeCounter();
        int itemCounter = ((Globals) this.getApplication()).getItemCounter();



    }
}