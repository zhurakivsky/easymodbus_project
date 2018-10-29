package com.example.easymodbus_project.controller;

import com.example.easymodbus_project.model.Device;
import de.re.easymodbus.exceptions.ModbusException;
import lombok.ToString;

import java.io.IOException;

@ToString

public class ReadDiscreteRegisters {


     static boolean[] discreteRegisters;

    public static void readDiscreteRegister(int quantity) {
        try {
            ModbusClientConnect.modbusClient.Connect();
        } catch (IOException e) {
            e.printStackTrace();
        }


        while (ModbusClientConnect.modbusClient.isConnected()) {
            try {
                discreteRegisters = ModbusClientConnect.modbusClient.ReadDiscreteInputs(0, quantity);
            } catch (ModbusException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Socket exc in DR");
                try {
                    ModbusClientConnect.modbusClient.Disconnect();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                readDiscreteRegister(quantity);
            }


            try {
                System.out.println(discreteRegisters.length);
            } catch (NullPointerException e) {
                System.out.println("error null");
                try {
                    ModbusClientConnect.modbusClient.Disconnect();
                } catch (IOException e1) {
                    e1.printStackTrace();


                }
                readDiscreteRegister(quantity);
            }
            try {
                ModbusClientConnect.modbusClient.Disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
