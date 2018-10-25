package com.example.easymodbus_project.service;

import com.example.easymodbus_project.model.InputRegister;

import java.util.List;

public interface InputRegisterService {
    InputRegister findById(int id);
    List<InputRegister> findAll();
    void save(InputRegister  inputRegister);
    void delete(int id);

}
