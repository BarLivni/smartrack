package com.example.smartrack.models;

public class Edge {
    public int id;
    public String node1; //  vertexID
    public String node2; //  vertexID
    public int weight;

    public Edge(int id, String node1, String node2, int weight) {
        this.id = id;
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }


}
