package com.example.smartrack.models;

public class User {
    public String uuid;
    public String name;
    public String surname;
    public String email;
    public String phone;
    public String password;

    public User(){
    }

    public User(String uuid,String name,String surname,String email,String phone,String password){
        this.uuid=uuid;
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.phone=phone;
        this.password=password;
    }


}
