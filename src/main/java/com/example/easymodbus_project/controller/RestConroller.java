package com.example.easymodbus_project.controller;

import com.example.easymodbus_project.model.CoilsRegister;
import com.example.easymodbus_project.model.HoldingRegister;
import com.example.easymodbus_project.model.InputRegister;
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


    @GetMapping("/request")
    public boolean req(){
        ModbusClientConnect modbusClientConnect = new ModbusClientConnect();
        return modbusClientConnect.isconnect;
    }
    @GetMapping("/holdingRegister/{id}")
    public int readHR(
        @PathVariable int id){
        HoldingRegister byId = holdingRegisterService.findById(id);
        int address = byId.getAddress();

        return ReadHoldingRegisters.readHoldingRegisters(address);
    }
    @GetMapping("/inputRegister/{id}")
    public int readIR(
            @PathVariable int id){
       InputRegister byId = inputRegisterService.findById(id);
        int address = byId.getAddress();

        return ReadInputRegisters.readInputRegisters(address);
    }
    @GetMapping("/coilsRegister/{id}")
    public boolean readCR(
            @PathVariable int id){

        CoilsRegister byId = coilsRegisterService.findById(id);
        int address = byId.getAddress();

        return ReadCoilsRegister.readCoilsRegister(address);
    }


}