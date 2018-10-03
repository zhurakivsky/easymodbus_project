package com.example.easymodbus_project.controller;

import com.example.easymodbus_project.model.Device;
import com.example.easymodbus_project.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    DeviceService deviceService;

    @GetMapping("/")
    public String mainpage (
            Model model
    ){
        List<Device> devices = deviceService.findAll();
        model.addAttribute("devices", devices);

        return "mainpage";




    }



    @GetMapping("/device/{id}")
    public String toDevice(
            @PathVariable int id,
            Model model
    ){
        Device devicebyId = deviceService.findById(id);
        model.addAttribute(devicebyId);

        return "device";
    }
    @GetMapping("/createDivice")
    public String createDivice(){
        return "createDevice";
    }

    @PostMapping("/addDevice")
    public String addDevice(
            @RequestParam String name,
            @RequestParam String ipadress,
            @RequestParam int port
    ){
        Device device = new Device();
        device.builder().ipadress(ipadress).name(name).port(port).build();
        System.out.println(device);
        deviceService.save(device);
        return "redirect:/";

    }




}
