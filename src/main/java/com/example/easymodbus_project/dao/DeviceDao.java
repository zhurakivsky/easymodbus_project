package com.example.easymodbus_project.dao;

import com.example.easymodbus_project.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface DeviceDao extends JpaRepository<Device,Integer> {


}
