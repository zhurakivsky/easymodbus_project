package com.example.easymodbus_project.controller;

import de.re.easymodbus.exceptions.ModbusException;
import lombok.ToString;

import java.io.IOException;

@ToString

public class ReadCoilsRegister {




    static boolean[] coilRegisters;

    public static void readCoilsRegister(int quantity) {
        try {
            ModbusClientConnect.modbusClient.Connect();
        } catch (IOException e) {
            e.printStackTrace();
        }


        while (ModbusClientConnect.modbusClient.isConnected()) {


            try {
                coilRegisters = ModbusClientConnect.modbusClient.ReadCoils(0, quantity);

            } catch (ModbusException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Socket exc in Coils");
                try {
                    ModbusClientConnect.modbusClient.Disconnect();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                readCoilsRegister(quantity);
            }


            try {
                System.out.println(coilRegisters.length);
            } catch (NullPointerException e) {
                System.out.println("error null");
                try {
                    ModbusClientConnect.modbusClient.Disconnect();
                } catch (IOException e1) {
                    e1.printStackTrace();


                }
                readCoilsRegister(quantity);
            }

            try {
                ModbusClientConnect.modbusClient.Disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
