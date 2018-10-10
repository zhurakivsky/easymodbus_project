package com.example.easymodbus_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.easymodbus_project.dao")
public class    EasymodbusProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasymodbusProjectApplication.class, args);
    }
}
