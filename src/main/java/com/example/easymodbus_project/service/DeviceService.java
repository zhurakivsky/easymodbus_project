package com.example.easymodbus_project.service;

import com.example.easymodbus_project.model.Device;

import java.util.List;
import java.util.Optional;

public interface DeviceService {

     Device findById(int id);
     List<Device> findAll();
     void save(Device device);
     void delete(int id);


}
