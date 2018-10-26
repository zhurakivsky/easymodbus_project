package com.example.easymodbus_project.controller;

import de.re.easymodbus.exceptions.ModbusException;

import java.io.IOException;

public class ReadCoilsRegister {



    public static boolean readCoilsRegister(int address){
        boolean valueToReturn = false;
        try {
            ModbusClientConnect.modbusClient.Connect();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        if(ModbusClientConnect.modbusClient.isConnected()){


            try {
                boolean[] arr = ModbusClientConnect.modbusClient.ReadCoils(address,1);
                valueToReturn = arr[0];
                System.out.println("address coils" + address+ "valuee" + valueToReturn);
            } catch (ModbusException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Socket exc in Coils");
                return false;
            }


        } else readCoilsRegister(address);
        return valueToReturn;
    }
}
