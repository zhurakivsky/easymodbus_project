package com.example.easymodbus_project.service;

import com.example.easymodbus_project.model.DiscreteRegister;

import java.util.List;

public interface DiscreteRegisterService {
    DiscreteRegister findById(int id);
    List<DiscreteRegister> findAll();
    void save(DiscreteRegister discreteRegister);
    void delete(int id);

}
