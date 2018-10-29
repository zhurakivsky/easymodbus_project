package com.example.easymodbus_project.controller;

import de.re.easymodbus.exceptions.ModbusException;

import java.io.IOException;

public class ReadInputRegisters {


    public static int readInputRegisters(int address) {
        int[] values;
        int valueToReturn = 8888;


        try {
            ModbusClientConnect.modbusClient.Connect();
        } catch (IOException e) {
            System.out.println("NO CONNECTION");

            return valueToReturn;
        }

        if (ModbusClientConnect.modbusClient.isConnected()) {
            try {

                values = ModbusClientConnect.modbusClient.ReadInputRegisters(address, 1);
                valueToReturn = values[0];

            } catch (ModbusException e) {
                e.printStackTrace();
                return 8888;
            } catch (IOException e) {
                System.out.println("socket exception in IR");
                return 8888;

            }
            try {
                ModbusClientConnect.modbusClient.Disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return valueToReturn;
        } else return 8888;
    }
}





