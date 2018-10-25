package com.example.easymodbus_project.dao;

import com.example.easymodbus_project.model.CoilsRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoilsRegisterDao extends JpaRepository<CoilsRegister,Integer> {
}
