package com.example.easymodbus_project.controller;

import de.re.easymodbus.exceptions.ModbusException;

import java.io.IOException;

public class WriteHoldingRegisters {




    public static void writeHoldingRegisters(int startingAdress, int value){

        try {
            ModbusClientConnect.modbusClient.Connect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ModbusClientConnect.modbusClient.WriteSingleRegister(startingAdress,value);
        } catch (ModbusException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
