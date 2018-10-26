package com.example.easymodbus_project.controller;

import com.example.easymodbus_project.model.HoldingRegister;
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


   @PutMapping("/write/change/{id}/{znak}")
    public int writeTestIncrement(
            @PathVariable int id,@PathVariable String znak){

       HoldingRegister byId = holdingRegisterService.findById(id);
       int value = ReadHoldingRegisters.readHoldingRegisters(byId.getAddress());
       if (znak.equals("+")) { value++; } else { value--; }

       WriteHoldingRegisters.writeHoldingRegisters(byId.getAddress(),value);
       return value;
    }


    @GetMapping("/request")
    public boolean req(){
        ModbusClientConnect modbusClientConnect = new ModbusClientConnect();
        return modbusClientConnect.isconnect;
    }
    @GetMapping("/register/{id}")
public int myModbusConnect(
        @PathVariable int id){
        HoldingRegister byId = holdingRegisterService.findById(id);
        int address = byId.getAddress();

        return ReadHoldingRegisters.readHoldingRegisters(address);
}


}