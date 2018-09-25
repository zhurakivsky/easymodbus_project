package com.example.easymodbus_project.controller;

import com.example.easymodbus_project.model.Device;
import com.example.easymodbus_project.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    DeviceService deviceService;

    @GetMapping("/")
    public String mainpage (){
        return "mainpage";

    }
    @GetMapping("/createDivice")
    public String createDivice(){
        return "createDevice";
    }

    @PostMapping("/addDevice")
    public String addDevice(Device device){
        deviceService.save(device);
        return "redirect:/";

    }



}
