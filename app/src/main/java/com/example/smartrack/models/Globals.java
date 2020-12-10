package com.example.smartrack.models;

import android.app.Application;

public class Globals extends Application {
        private int vertexCounter;
        private int edgeCounter;
        private int itemCounter;
        private Graph mGraph = new Graph();


    public int getVertexCounter() {
        return vertexCounter;
    }

    public int getEdgeCounter() {
        return edgeCounter;
    }

    public int getItemCounter() {
        return itemCounter;
    }

    public void setVertexCounter(int vertexCounter) {
        this.vertexCounter = vertexCounter;
    }

    public void setEdgeCounter(int edgeCounter) {
        this.edgeCounter = edgeCounter;
    }

    public void setItemCounter(int itemCounter) {
        this.itemCounter = itemCounter;
    }


}
