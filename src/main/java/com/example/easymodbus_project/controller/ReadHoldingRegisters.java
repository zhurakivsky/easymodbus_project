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
            return 8888;
        }
        if (ModbusClientConnect.modbusClient.isConnected()) {
            try {
                holdRegisters = ModbusClientConnect.modbusClient.ReadHoldingRegisters(address, 1);
                System.out.println("HR address " + address +"; holding  na returni"  + holdRegisters[0]);
                valueOfRegister = holdRegisters[0];
            } catch (ModbusException e) {
                e.printStackTrace();
                System.out.println("Modbus Exception to read HR");
                return 8888;
            } catch (IOException e) {
                System.out.println(" Socket Exception in HR");
                return 8888;
            }
        }else return 8888;



            try {
                ModbusClientConnect.modbusClient.Disconnect();

            } catch (IOException e) {
                e.printStackTrace();
            }

    return valueOfRegister;}

}