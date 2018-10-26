package com.example.easymodbus_project.controller;

import com.example.easymodbus_project.model.CoilsRegister;
import com.example.easymodbus_project.model.DiscreteRegister;
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
        return ReadHoldingRegisters.readHoldingRegisters(holdingRegisterService.findById(id).getAddress());
    }
    @GetMapping("/inputRegister/{id}")
    public int readIR(
            @PathVariable int id){
        return ReadInputRegisters.readInputRegisters(inputRegisterService.findById(id).getAddress());
    }
    @GetMapping("/coilsRegister/{id}")
    public boolean readCR(
            @PathVariable int id){
        return ReadCoilsRegister.readCoilsRegister(coilsRegisterService.findById(id).getAddress());
    }
    @GetMapping("/discreteRegister/{id}")
    public boolean readDR(
            @PathVariable int id){
        return ReadDiscreteRegisters.readDiscreteRegister(discreteRegisterService.findById(id).getAddress());
    }


}