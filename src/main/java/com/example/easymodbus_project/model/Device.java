package com.example.easymodbus_project.model;


import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ToString

public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private String ipadress;
    private int port;

    public Device(){
    }

    public Device(String name, String ipadress, int port) {
        this.name = name;
        this.ipadress = ipadress;
        this.port = port;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpadress() {
        return ipadress;
    }

    public void setIpadress(String ipadress) {
        this.ipadress = ipadress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
