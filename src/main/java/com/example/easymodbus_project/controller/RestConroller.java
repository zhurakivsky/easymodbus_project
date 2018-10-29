package com.example.easymodbus_project.controller;

import com.example.easymodbus_project.model.*;
import com.example.easymodbus_project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class RestConroller {

    @Autowired
    DeviceService deviceService;
    @Autowired
    HoldingRegisterService holdingRegisterService;
    @Autowired
    private InputRegisterService inputRegisterService;
    @Autowired
    private CoilsRegisterService coilsRegisterService;
    @Autowired
    private DiscreteRegisterService discreteRegisterService;


   @PutMapping("/write/holdingRegister/{id}/{value}")
    public int writeTestIncrement(
            @PathVariable int id,@PathVariable int value){

       HoldingRegister byId = holdingRegisterService.findById(id);

       WriteHoldingRegisters.writeHoldingRegisters(byId.getAddress(),value);
       return value;
    }
    @PutMapping("/write/coilsRegister/{id}/{value}")
    public boolean writeSingleCoils(
            @PathVariable int id,
            @PathVariable Boolean value){

        WriteCoilsRegister.writeCoilsRegister(coilsRegisterService.findById(id).getAddress(),!value);
        return !value;
    }



    @GetMapping("/request/{id}")
    public boolean request(
            @PathVariable int id
    ){
        Device byId = deviceService.findById(id);
        ModbusClientConnect modbusClientConnect = new ModbusClientConnect();
        ReadHoldingRegisters.readHoldingRegisters(byId.getQuantityHR());
        ReadCoilsRegister.readCoilsRegister(byId.getQuantityCR());
        ReadDiscreteRegisters.readDiscreteRegister(byId.getQuantityDR());
        ReadInputRegisters.readInputRegisters(byId.getQuantityIR());

//        for (int holdingRegister : ReadHoldingRegisters.holdingRegisters) {
//            System.out.println(holdingRegister);
//        }

        return modbusClientConnect.isconnect;
    }
    @GetMapping("/holdingRegister/{id}")
    public int readHR(
        @PathVariable int id){


        HoldingRegister byId = holdingRegisterService.findById(id);

        return ReadHoldingRegisters.holdingRegisters[byId.getAddress()];
    }
    @GetMapping("/inputRegister/{id}")
    public int readIR(
            @PathVariable int id){

        InputRegister byId = inputRegisterService.findById(id);

        return ReadInputRegisters.inputRegisters[byId.getAddress()];
    }
    @GetMapping("/coilsRegister/{id}")
    public boolean readCR(
            @PathVariable int id){
        CoilsRegister byId = coilsRegisterService.findById(id);

        return ReadCoilsRegister.coilRegisters[byId.getAddress()];
    }
    @GetMapping("/discreteRegister/{id}")
    public boolean readDR(
            @PathVariable int id){
        DiscreteRegister byId = discreteRegisterService.findById(id);

        return ReadDiscreteRegisters.discreteRegisters[byId.getAddress()];
    }


}