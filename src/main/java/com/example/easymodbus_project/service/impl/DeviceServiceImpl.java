package com.example.easymodbus_project.service.impl;

import com.example.easymodbus_project.dao.DeviceDao;
import com.example.easymodbus_project.model.Device;
import com.example.easymodbus_project.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceService{
    @Autowired
    private DeviceDao deviceDao;
    @Override
    public Device findById(int id) {

        return deviceDao.findById(id).get();
    }

    @Override
    public List<Device> findAll() {
        return deviceDao.findAll();
    }

    @Override
    public void save(Device device) {
        deviceDao.save(device);
    }

    @Override
    public void delete(int id) {
     deviceDao.deleteById(id);
    }
}
