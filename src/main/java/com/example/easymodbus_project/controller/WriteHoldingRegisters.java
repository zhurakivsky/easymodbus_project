package com.example.easymodbus_project.controller;

import de.re.easymodbus.exceptions.ModbusException;

import java.io.IOException;

public class WriteHoldingRegisters {




    public static void writeHoldingRegisters(int startingAddress, int value){
        try {
            ModbusClientConnect.modbusClient.Disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ModbusClientConnect.modbusClient.Connect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ModbusClientConnect.modbusClient.WriteSingleRegister(startingAddress,value);
        } catch (ModbusException | IOException e) {
            e.printStackTrace();

        }

        try {
            ModbusClientConnect.modbusClient.Disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
