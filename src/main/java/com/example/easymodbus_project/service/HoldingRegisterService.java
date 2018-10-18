package com.example.easymodbus_project.service;

import com.example.easymodbus_project.model.Device;
import com.example.easymodbus_project.model.HoldingRegister;

import java.util.List;

public interface HoldingRegisterService {

     HoldingRegister findById(int id);
     List<HoldingRegister> findAll();
     void save(HoldingRegister holdingRegister);
     void delete(int id);


}
