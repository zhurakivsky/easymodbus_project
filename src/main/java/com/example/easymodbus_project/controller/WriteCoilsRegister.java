package com.example.easymodbus_project.controller;

import de.re.easymodbus.exceptions.ModbusException;

import java.io.IOException;

public class WriteCoilsRegister {


    public  static  void writeCoilsRegister(int address, boolean value){

        try {
            ModbusClientConnect.modbusClient.Disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ModbusClientConnect.modbusClient.Connect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ModbusClientConnect.modbusClient.WriteSingleCoil(address,value);
        } catch (ModbusException | IOException e) {
            e.printStackTrace();
        }
        try {
            ModbusClientConnect.modbusClient.Disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
