package com.example.easymodbus_project.controller;

import de.re.easymodbus.exceptions.ModbusException;

import java.io.IOException;

public class ReadInputRegisters {




    public static int readInputRegisters(int address) {
        int[] values = new int[1];
        int valueToReturn ;



        try {
            ModbusClientConnect.modbusClient.Connect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (ModbusClientConnect.modbusClient.isConnected()) {
            try {

                values = ModbusClientConnect.modbusClient.ReadInputRegisters(address, 1);
                System.out.println("addres " + address+ ";input value   - -  " + values[0]);

            } catch (ModbusException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("socket exception in IR");
                try {
                    ModbusClientConnect.modbusClient.Disconnect();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                readInputRegisters(address);
            }
            valueToReturn = values[0];

            } else return 888;
            try {
                ModbusClientConnect.modbusClient.Disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return valueToReturn;
        }
    }





