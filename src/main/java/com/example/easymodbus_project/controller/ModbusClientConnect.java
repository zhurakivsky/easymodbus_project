package com.example.easymodbus_project.controller;

import de.re.easymodbus.modbusclient.ModbusClient;

import java.io.IOException;

public class ModbusClientConnect{

    public static String ipAddress;
    public static int port;
     static ModbusClient modbusClient;





     public boolean isconnect;

    public ModbusClientConnect(){
        modbusClient = new ModbusClient(ipAddress, port);
//        modbusClient.setConnectionTimeout(3000);
//        System.out.println(modbusClient.getConnectionTimeout());
        try {
            modbusClient.Connect();
            isconnect = modbusClient.isConnected();

//            System.out.println(modbusClient.getConnectionTimeout());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }





    }

