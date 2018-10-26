package com.example.easymodbus_project.controller;

import de.re.easymodbus.exceptions.ModbusException;

import java.io.IOException;

public class ReadDiscreteRegisters {



    public static boolean readDiscreteRegister(int address){
        boolean valuerToReturn ;

        try {
            ModbusClientConnect.modbusClient.Connect();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        if(ModbusClientConnect.modbusClient.isConnected()){
            try {
                boolean[] values = ModbusClientConnect.modbusClient.ReadDiscreteInputs(address, 1);
                valuerToReturn = values[0];
            } catch (ModbusException e) {
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                System.out.println("Socket exc in DR");
                return false;
            }


        }else return false;

        return valuerToReturn;
    }

}
