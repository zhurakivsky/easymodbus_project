package com.example.easymodbus_project;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class RestConroller {



    public static int registr17 = 0;
    public static int registr18 = 0;
    public static int registr19 = 0;
    public static int registr20 = 0;
    public static int registr21 = 0;

    public static int holdingregistr1;
    public static int startAdress;
    public static int valueAdress;








//    ModbusClientConnect modbusClientConnect = new ModbusClientConnect("192.168.0.110", 1502);
//


   @PostMapping("/write/test")
    public int writeTest(
            @RequestParam int start,
            @RequestParam int value

    ){
        startAdress = start;
        valueAdress = value;
        System.out.println("стартовий адрес запису" +startAdress);

        System.out.println(value);
//        ModbusClientConnect modbusClientConnect = new ModbusClientConnect();
        WriteHoldingRegisters.writeHoldingRegisters(start,value);
        return start;

    }





    @GetMapping("/hre1")
    public int readholdingr1(){
        return holdingregistr1;

    }

    @GetMapping("/req")
    public boolean req(){
        ModbusClientConnect modbusClientConnect = new ModbusClientConnect();

        ReadInputRegisters.readInputRegisters();

        ReadHoldingRegisters.readHoldingRegisters();


//        System.out.println(modbusClientConnect.modbusClient.isConnected());

        return modbusClientConnect.isconnect;
//

    }




    @GetMapping("/reg17")
public int myModbusConnect17(){
//        ModbusClientConnect modbusClientConnect1 = new ModbusClientConnect("192.168.0.107", 502);\

    return
//            modbusClientConnect1.reg17;
        registr17;
}
    @GetMapping("/reg18")
    public int myModbusConnect18(){
//        ModbusClientConnect modbusClientConnect= new ModbusClientConnect("192.168.0.107", 502);
//        ModbusClientConnect modbusClientConnect2 = new ModbusClientConnect("192.168.0.107", 502);
//        modbusClientConnect.run();
//        Thread thread3 = new Thread(modbusClientConnect2);
//        thread3.start();
        return
//              modbusClientConnect2.reg18;
         registr18;
    }
    @GetMapping("/reg19")
    public int myModbusConnect19(){
//        ModbusClientConnect modbusClientConnect3 = new ModbusClientConnect("192.168.0.107", 502);
//        ModbusClientConnect modbusClientConnect3 = new ModbusClientConnect("192.168.0.107", 502);
//        modbusClientConnect.run();
//        Thread thread1 = new Thread(modbusClientConnect3);
//        thread1.start();
        return
//                modbusClientConnect3.reg19;
        registr19;
    }

    @GetMapping("/reg20")
    public int myModbusConnect20(){
//        ModbusClientConnect modbusClientConnect4 = new ModbusClientConnect("192.168.0.107", 502);
//        ModbusClientConnect modbusClientConnect4 = new ModbusClientConnect("192.168.0.107", 502);
//        modbusClientConnect4.run();
//        Thread thread2 = new Thread(modbusClientConnect4);
//        thread2.start();
        return
//                modbusClientConnect4.reg20;
        registr20;
    }

}