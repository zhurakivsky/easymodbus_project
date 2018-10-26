package com.example.easymodbus_project.controller;

import de.re.easymodbus.exceptions.ModbusException;

import java.io.IOException;

public class ReadHoldingRegisters {

    private static int [] holdRegisters;
    private static int address1;




    public static int readHoldingRegisters(int address) {
        int valueOfRegister = 0;
        address1 = address;

        try {
            ModbusClientConnect.modbusClient.Connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (ModbusClientConnect.modbusClient.isConnected()) {
            try {
                holdRegisters = ModbusClientConnect.modbusClient.ReadHoldingRegisters(address, 1);
                System.out.println("HR address " + address +"; holding  na returni"  + holdRegisters[0]);
            } catch (ModbusException e) {
                e.printStackTrace();
                System.out.println("Modbus Exception to read HR");
            } catch (IOException e) {
                System.out.println(" Socket Exception in HR");
                try {
                    ModbusClientConnect.modbusClient.Disconnect();
                } catch (IOException e1) {
                    System.out.println("error3--disconnect");
                    e1.printStackTrace();
                }
                readHoldingRegisters(address);

            }
        }else return 777;

            for (int j = 0; j < holdRegisters.length; j++) {
                valueOfRegister = holdRegisters[j];

            }

            try {
                ModbusClientConnect.modbusClient.Disconnect();

            } catch (IOException e) {
                e.printStackTrace();
            }

    return valueOfRegister;}

}