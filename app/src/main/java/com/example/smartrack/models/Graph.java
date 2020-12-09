package com.example.smartrack.models;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class Graph {
    // symbol table: key = string vertex, value = set of neighboring vertices
    public HashMap<String, LinkedHashSet<String>> graph;
    public Edge edges;

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

        /*
        public void addEdge(Vertex node1, Vertex node2) {

            LinkedHashSet<Vertex> adjacent = graph.get(node1); // build the adjacent set/list
            if (adjacent == null) {
                adjacent = new LinkedHashSet();
                graph.put(node1, adjacent);
            }
            adjacent.add(node2);
        }

        public void addTwoWayVertex(Vertex node1, Vertex node2) {
            addEdge(node1, node2);
            addEdge(node2, node1);
        }
        */
    }

    public void getNumberAdjEdge(String vertexId){
       // Integer sum = graph.values().stream().mapToInt(List::size).sum();
        //return ;
    }
    public LinkedHashSet<String> getAdjacencyList(String vertexId){
        return graph.get(vertexId);
    }

    public int verticesNumber(){
        return graph.size();
    }



}

