package com.example.easymodbus_project.service;

import com.example.easymodbus_project.dao.DeviceDao;
import com.example.easymodbus_project.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceDao deviceDao;

    @Override
    public Device findById(int id) {

        return deviceDao.getOne(id);
    }

    @Override
    public List<Device> findAll() {
        return  deviceDao.findAll();
    }

    @Override
    public void save(Device device) {

        deviceDao.save(device);

    }
}
