package com.example.easymodbus_project.service;

import com.example.easymodbus_project.model.Device;

import java.util.List;

public interface DeviceService {

     Device findById(int id);
     List<Device> findAll();
     void save(Device device);


}
