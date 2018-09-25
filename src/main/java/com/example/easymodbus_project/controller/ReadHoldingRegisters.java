package com.example.easymodbus_project.controller;

import de.re.easymodbus.exceptions.ModbusException;

import java.io.IOException;

public class ReadHoldingRegisters {

    public static int [] holdRegisters;


    public static void readHoldingRegisters() {

        try {
            ModbusClientConnect.modbusClient.Connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (ModbusClientConnect.modbusClient.isConnected()) {
            System.out.println("зчитування ходінг регістрів   "+ModbusClientConnect.modbusClient.isConnected());
            try {
                holdRegisters = ModbusClientConnect.modbusClient.ReadHoldingRegisters(1, 1);
            } catch (ModbusException e) {
                e.printStackTrace();
                System.out.println("error1");
            } catch (IOException e) {
//                e.printStackTrace();
                System.out.println("error2");
                try {
                    ModbusClientConnect.modbusClient.Disconnect();
                } catch (IOException e1) {
                    System.out.println("error3");
                    e1.printStackTrace();
                }
                readHoldingRegisters();

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
                readHoldingRegisters();
            }

            for (int j = 0; j < holdRegisters.length; j++) {
                RestConroller.holdingregistr1 = holdRegisters[j];
                System.out.println(holdRegisters[j]);

            }
//
            try {
                ModbusClientConnect.modbusClient.Disconnect();
                System.out.println("disconnect");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
