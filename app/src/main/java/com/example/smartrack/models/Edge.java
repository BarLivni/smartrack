package com.example.smartrack.models;

public class Edge {
    public int id;
    public int node1; //  vertexID
    public int node2; //  vertexID
    public int weight;

    public Edge(int id, int node1, int node2, int weight) {
        this.id = id;
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }


}
