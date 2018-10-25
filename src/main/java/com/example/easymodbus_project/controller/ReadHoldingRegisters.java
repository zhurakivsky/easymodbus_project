package com.example.easymodbus_project.controller;

import de.re.easymodbus.exceptions.ModbusException;

import java.io.IOException;

public class ReadHoldingRegisters {

    private static int [] holdRegisters;



    public static int readHoldingRegisters(int address) {
        int valueOfRegister = 0;

        try {
            ModbusClientConnect.modbusClient.Connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (ModbusClientConnect.modbusClient.isConnected()) {
//
            try {
                holdRegisters = ModbusClientConnect.modbusClient.ReadHoldingRegisters(address, 1);
            } catch (ModbusException e) {
                e.printStackTrace();
                System.out.println("Modbus Exception to read HR");
            } catch (IOException e) {
//                e.printStackTrace();
                System.out.println(" Socket Exception");
                try {
                    ModbusClientConnect.modbusClient.Disconnect();
                } catch (IOException e1) {
                    System.out.println("error3--disconnect");
                    e1.printStackTrace();
                }
                readHoldingRegisters(address);

            }

            try {
                System.out.println(holdRegisters.length); // Потрібно поміняти метод відловлювання null!!!!
            }
            catch (NullPointerException e){
                System.out.println("error null");
                try {
                    ModbusClientConnect.modbusClient.Disconnect();
                } catch (IOException e1) {
                    e1.printStackTrace();

                }
                readHoldingRegisters(address);
            }

            for (int j = 0; j < holdRegisters.length; j++) {
                valueOfRegister = holdRegisters[j];

            }
//
            try {
                ModbusClientConnect.modbusClient.Disconnect();
//
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    return valueOfRegister;}

}