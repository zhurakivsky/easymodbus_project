package com.example.easymodbus_project;

import de.re.easymodbus.exceptions.ModbusException;
import de.re.easymodbus.modbusclient.ModbusClient;

import java.io.IOException;

public class ModbusClientConnect{

    public static String ipAdress =  "192.168.0.110";
    public static int port = 1502;
     static ModbusClient modbusClient;





     public boolean isconnect;

    public ModbusClientConnect(){
        modbusClient = new ModbusClient(ipAdress, port);
//        modbusClient.setConnectionTimeout(3000);
        System.out.println(modbusClient.getConnectionTimeout());
        try {
            modbusClient.Connect();
            isconnect = modbusClient.isConnected();

//            System.out.println(modbusClient.getConnectionTimeout());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }





    }

