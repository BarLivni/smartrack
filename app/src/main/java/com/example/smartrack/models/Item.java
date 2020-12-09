package com.example.smartrack.models;

import com.example.smartrack.models.Vertex;

public class Item {
    public int serialNumber;    // unique ID
    public String name;
    public int value;        // price
    public int weight;
    public Vertex location;     //VertexID


    public int getSerialNumber(){
        return this.serialNumber;
    }
}
