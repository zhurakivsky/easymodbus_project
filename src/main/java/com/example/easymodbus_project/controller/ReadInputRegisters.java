package com.example.easymodbus_project.controller;

import de.re.easymodbus.exceptions.ModbusException;

import java.io.IOException;

public class ReadInputRegisters {
    public static int [] registres;
    public static int reg17;
    public static int reg18;
    public static int reg19;
    public static int reg20;
    public static int reg21;





    public static void readInputRegisters() {



        while (ModbusClientConnect.modbusClient.isConnected()) {

//            System.out.println(ModbusClientConnect.modbusClient.isConnected());





            try {

                registres = ModbusClientConnect.modbusClient.ReadInputRegisters(17, 5);
            } catch (ModbusException e) {
                e.printStackTrace();
            } catch (IOException e) {
//                e.printStackTrace();
                try {
                    ModbusClientConnect.modbusClient.Disconnect();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                readInputRegisters();


            }



            try {
                System.out.println(registres.length);
            }
            catch (NullPointerException e){
                System.out.println("error null");
                try {
                    ModbusClientConnect.modbusClient.Disconnect();
                } catch (IOException e1) {
                    e1.printStackTrace();

                }
                readInputRegisters();
            }

//            for (int i = 0; i < registres.length; i++) {
//
//                reg17 = registres[0];
//                reg18 = registres[1];
//                reg19 = registres[2];
//                reg20 = registres[3];
//                reg21 = registres[4];
//
//
//
//                RestConroller.registr17 = reg17;
//                RestConroller.registr18 = reg18;
//                RestConroller.registr19 = reg19;
//                RestConroller.registr20 = reg20;
//                RestConroller.registr21 = reg21;

            }



            try {
                ModbusClientConnect.modbusClient.Disconnect();
//                System.out.println("disconnect");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//
//        System.out.println(reg17);
//        System.out.println(reg18);
//        System.out.println(reg19);
//        System.out.println(reg20);
//        System.out.println(reg21);
    }




