package com.example.easymodbus_project.dao;


import com.example.easymodbus_project.model.DiscreteRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscreteRegisterDao extends JpaRepository<DiscreteRegister,Integer> {
}
