package com.example.easymodbus_project.service.impl;

import com.example.easymodbus_project.dao.CoilsRegisterDao;
import com.example.easymodbus_project.model.CoilsRegister;
import com.example.easymodbus_project.service.CoilsRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CoilsRegisterServiceImpl  implements CoilsRegisterService{


    @Autowired
    private CoilsRegisterDao coilsRegisterDao;
    @Override
    public CoilsRegister findById(int id) {
        return coilsRegisterDao.findById(id).get();
    }

    @Override
    public List<CoilsRegister> findAll() {
        return coilsRegisterDao.findAll();
    }

    @Override
    public void save(CoilsRegister coilsRegister) {
        coilsRegisterDao.save(coilsRegister);
    }

    @Override
    public void delete(int id) {
        coilsRegisterDao.deleteById(id);
    }
}
