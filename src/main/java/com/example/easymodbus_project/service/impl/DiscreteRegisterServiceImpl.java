package com.example.easymodbus_project.service.impl;

import com.example.easymodbus_project.dao.DiscreteRegisterDao;
import com.example.easymodbus_project.model.DiscreteRegister;
import com.example.easymodbus_project.service.DiscreteRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DiscreteRegisterServiceImpl implements DiscreteRegisterService {
    @Autowired
    private DiscreteRegisterDao discreteRegisterDao;
    @Override
    public DiscreteRegister findById(int id) {
        return discreteRegisterDao.findById(id).get();
    }

    @Override
    public List<DiscreteRegister> findAll() {
        return discreteRegisterDao.findAll();
    }

    @Override
    public void save(DiscreteRegister discreteRegister) {
        discreteRegisterDao.save(discreteRegister);
    }

    @Override
    public void delete(int id) {
        discreteRegisterDao.deleteById(id);
    }
}
