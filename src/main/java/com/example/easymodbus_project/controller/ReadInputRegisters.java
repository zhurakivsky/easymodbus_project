package com.example.easymodbus_project.controller;

import de.re.easymodbus.exceptions.ModbusException;
import lombok.ToString;

import java.io.IOException;


@ToString
public class ReadInputRegisters {

    static int[] inputRegisters;

    public static void readInputRegisters(int quantity) {


        try {
            ModbusClientConnect.modbusClient.Connect();
        } catch (IOException e) {
            e.printStackTrace();
        }



        while (ModbusClientConnect.modbusClient.isConnected()) {
            try {

                inputRegisters = ModbusClientConnect.modbusClient.ReadInputRegisters(0, quantity);

            } catch (ModbusException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("socket exception in IR");
                try {
                    ModbusClientConnect.modbusClient.Disconnect();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                readInputRegisters(quantity);

            }
            try {
                System.out.println(inputRegisters.length);
            }
            catch (NullPointerException e) {
                System.out.println("error null");
                try {
                    ModbusClientConnect.modbusClient.Disconnect();
                } catch (IOException e1) {
                    e1.printStackTrace();


                }
                readInputRegisters(quantity);
            }
            try {
                ModbusClientConnect.modbusClient.Disconnect();
            } catch (IOException e2) {
                e2.printStackTrace();
            }


        }
    }
}






