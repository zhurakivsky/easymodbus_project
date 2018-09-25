package com.example.easymodbus_project.service;

import com.example.easymodbus_project.model.Device;

import java.util.List;

public interface DeviceService {

    public Device findById(int id);
    public List<Device> findAll();
    public void save(Device device);


}
