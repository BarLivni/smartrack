package com.example.smartrack.models;

import java.util.Vector;

public class Vertex {
    //public String id = UUID.randomUUID().toString(); // מספר רץ
    public String zipcode; //ID
    public String city;
    public String address;
    public Vector<Item> itemsInVertex= new Vector<Item>();
    public boolean isVisited;
    public boolean takeItem;

    public Vertex(String zipcode, String city, String address) {
        this.zipcode = zipcode;
        this.city = city;
        this.address = address;
        this.isVisited = false;
        this.takeItem = false;
    }
}
