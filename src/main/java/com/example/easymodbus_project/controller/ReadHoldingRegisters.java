package com.example.easymodbus_project.controller;

import de.re.easymodbus.exceptions.ModbusException;
import lombok.ToString;

import java.io.IOException;

@ToString

public class ReadHoldingRegisters {

    static int [] holdingRegisters ;

    public static void readHoldingRegisters(int quantity) {


        try {
            ModbusClientConnect.modbusClient.Connect();
        } catch (IOException e) {
            e.printStackTrace();
        }


        while (ModbusClientConnect.modbusClient.isConnected()) {
            try {
                holdingRegisters = ModbusClientConnect.modbusClient.ReadHoldingRegisters(0, quantity);

            } catch (ModbusException e) {
                e.printStackTrace();
                System.out.println("Modbus Exception to read HR");
            } catch (IOException e) {
                System.out.println(" Socket Exception in HR");
                try {
                    ModbusClientConnect.modbusClient.Disconnect();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                readHoldingRegisters(quantity);
            }


            try {
                System.out.println(holdingRegisters.length);
            } catch (NullPointerException e) {
                System.out.println("error null");
                try {
                    ModbusClientConnect.modbusClient.Disconnect();
                } catch (IOException e1) {
                    e1.printStackTrace();


                }
                readHoldingRegisters(quantity);
            }


            try {
                ModbusClientConnect.modbusClient.Disconnect();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}