package com.example.easymodbus_project.controller;

import de.re.easymodbus.modbusclient.ModbusClient;

import java.io.IOException;

public class ModbusClientConnect{

    public static String ipAddress;
    public static int port;
     static ModbusClient modbusClient;




     public boolean isconnect;

     ModbusClientConnect(){
        modbusClient = new ModbusClient(ipAddress, port);


        try {
            modbusClient.Connect();
            isconnect = modbusClient.isConnected();

        } catch (IOException e) {
            System.out.println("NO CONNECTION");
        }



    }





    }

