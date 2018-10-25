package com.example.easymodbus_project.service.impl;

import com.example.easymodbus_project.dao.InputRegisterDao;
import com.example.easymodbus_project.model.InputRegister;
import com.example.easymodbus_project.service.InputRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InputRegisterServiceImpl implements InputRegisterService {

    @Autowired
    private InputRegisterDao inputRegisterDao;
    @Override
    public InputRegister findById(int id) {
        return inputRegisterDao.findById(id).get();
    }

    @Override
    public List<InputRegister> findAll() {
        return inputRegisterDao.findAll();
    }

    @Override
    public void save(InputRegister inputRegister) {
        inputRegisterDao.save(inputRegister);
    }

    @Override
    public void delete(int id) {
        inputRegisterDao.deleteById(id);
    }
}
