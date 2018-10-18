package com.example.easymodbus_project.dao;

import com.example.easymodbus_project.model.Device;
import com.example.easymodbus_project.model.HoldingRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoldingRegisterDao extends JpaRepository<HoldingRegister,Integer> {


}
