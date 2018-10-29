package com.example.easymodbus_project.controller;

import de.re.easymodbus.exceptions.ModbusException;

import java.io.IOException;

public class ReadDiscreteRegisters {



    public static String readDiscreteRegister(int address){
        String valuerToReturn = "error" ;

        try {
            ModbusClientConnect.modbusClient.Connect();
        } catch (IOException e) {
            System.out.println("NO CONNECTION");

            return valuerToReturn;
        }
        if(ModbusClientConnect.modbusClient.isConnected()){
            try {
                boolean[] values = ModbusClientConnect.modbusClient.ReadDiscreteInputs(address, 1);
                valuerToReturn = "" + values[0];
            } catch (ModbusException e) {
                e.printStackTrace();
                return valuerToReturn;
            } catch (IOException e) {
                System.out.println("Socket exc in DR");
                return valuerToReturn;
            }


        }else readDiscreteRegister(address);

        return valuerToReturn;
    }

}
