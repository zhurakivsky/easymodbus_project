package com.example.easymodbus_project.service;

import com.example.easymodbus_project.model.CoilsRegister;

import java.util.List;

public interface CoilsRegisterService {
    CoilsRegister findById(int id);
    List<CoilsRegister> findAll();
    void save(CoilsRegister coilsRegister);
    void delete(int id);

}
