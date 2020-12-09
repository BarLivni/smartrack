package com.example.smartrack.models;

import java.util.ArrayList;
import java.util.Vector;

public class Path {
    int id;
    Vector<Vertex> pathVertices=new Vector<Vertex>();
    Vector<Edge> pathEdges=new Vector<Edge>();

    public int getTotalEdgeWeight(){
        int totalEdgePathWeight = 0;
        for (Edge e:pathEdges) {
            totalEdgePathWeight+=e.weight;
        }
        return totalEdgePathWeight;
    }
    public ArrayList<Item> getAllPathItemList() {
        ArrayList<Item> allPathItems = new ArrayList<Item>();
        for (Vertex v : pathVertices) {
            allPathItems.addAll(v.itemsInVertex);
        }
        return allPathItems;
    }
}
