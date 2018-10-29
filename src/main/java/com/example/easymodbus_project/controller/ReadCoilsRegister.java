package com.example.easymodbus_project.controller;

import de.re.easymodbus.exceptions.ModbusException;

import java.io.IOException;

public class ReadCoilsRegister {



    public static String readCoilsRegister(){
        String valueToReturn = "error";
        try {
            ModbusClientConnect.modbusClient.Connect();
        } catch (IOException e) {
            System.out.println("NO CONNECTION");

            return "error";
        }

        if(ModbusClientConnect.modbusClient.isConnected()){


            try {
                boolean[] arr = ModbusClientConnect.modbusClient.ReadCoils(0,100);
                valueToReturn = "" + arr[0];
            } catch (ModbusException e) {
                e.printStackTrace();
                return valueToReturn;
            } catch (IOException e) {
                System.out.println("Socket exc in Coils");
                return valueToReturn;
            }


        } else readCoilsRegister(address);
        return valueToReturn;
    }
}
