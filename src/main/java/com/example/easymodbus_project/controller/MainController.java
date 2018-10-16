package com.example.easymodbus_project.controller;

import com.example.easymodbus_project.model.Device;
import com.example.easymodbus_project.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/device/del/{id}")
    public String deleteDevice(
            @PathVariable int id
    ){
        deviceService.delete(id);
        return "redirect:/";
    }
//    @GetMapping("/device/editName/{id}")
//    public String editName(
//            @PathVariable int id
//    ){
//        deviceService.findById(id);
//        return "redirect:/";
//    }

    @PostMapping("/addDevice")
    public String addDevice(
            @RequestParam String name,
            @RequestParam String ipadress,
            @RequestParam int port
    ){

        System.out.println(name);
        Device device = Device.builder().ipadress(ipadress).name(name).port(port).build();;

        System.out.println(device.getName());
        deviceService.save(device);
        return "redirect:/";

    }
    @PostMapping("/setName")
    public String   setName(
            @RequestBody Device device
    )



    {
        Device deviceServiceById = deviceService.findById(device.getId());
        deviceServiceById.setName(device.getName());

        deviceService.save(deviceServiceById);
        System.out.println(deviceServiceById);
        return "redirect:/";



    }




}
