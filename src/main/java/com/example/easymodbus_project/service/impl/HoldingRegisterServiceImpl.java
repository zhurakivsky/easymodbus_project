package com.example.easymodbus_project.service.impl;

import com.example.easymodbus_project.dao.DeviceDao;
import com.example.easymodbus_project.dao.HoldingRegisterDao;
import com.example.easymodbus_project.model.Device;
import com.example.easymodbus_project.model.HoldingRegister;
import com.example.easymodbus_project.service.DeviceService;
import com.example.easymodbus_project.service.HoldingRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HoldingRegisterServiceImpl implements HoldingRegisterService {
    @Autowired
    private HoldingRegisterDao holdingRegisterDao;
    @Override
    public HoldingRegister findById(int id) {

        return holdingRegisterDao.findById(id).get();
    }

    @Override
    public List<HoldingRegister> findAll() {
        return holdingRegisterDao.findAll();
    }

    @Override
    public void save(HoldingRegister holdingRegister) {
        holdingRegisterDao.save(holdingRegister);
    }

    @Override
    public void delete(int id) {
     holdingRegisterDao.deleteById(id);
    }
}
