package com.example.easymodbus_project.controller;

import com.example.easymodbus_project.model.Device;
import com.example.easymodbus_project.model.HoldingRegister;
import com.example.easymodbus_project.service.DeviceService;
import com.example.easymodbus_project.service.HoldingRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    DeviceService deviceService;
    @Autowired
    HoldingRegisterService holdingRegisterService;

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
        List<HoldingRegister> all = devicebyId.getHoldingRegisters();
        model.addAttribute("holdingRegisters", all);
        String ipAddress = devicebyId.getIpAddress();
        ModbusClientConnect.ipAddress = ipAddress;
        int port = devicebyId.getPort();
        System.out.println(port);
        System.out.println(ipAddress);
        ModbusClientConnect.port = port;

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
            @RequestParam String ipAddress,
            @RequestParam int port
    ){

        System.out.println(name);
        Device device = Device.builder().ipAddress(ipAddress).name(name).port(port).build();

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

        return "redirect:/";


    }

    @PostMapping("/setIpAddress")
    public String   setIp(
            @RequestBody Device device
    )



    {
        Device deviceServiceById = deviceService.findById(device.getId());
        deviceServiceById.setIpAddress(device.getIpAddress());

        deviceService.save(deviceServiceById);

        return "redirect:/";


    }

    @PostMapping("/setPort")
    public String   setPort(
            @RequestBody Device device
    )



    {
        Device deviceServiceById = deviceService.findById(device.getId());
        deviceServiceById.setPort(device.getPort());

        deviceService.save(deviceServiceById);

        return "redirect:/";


    }

    @PostMapping("/device/createHR/{id}")
    public String   createHR(
            @RequestBody HoldingRegister holdingRegister,
            @PathVariable int id


            )


    {
        System.out.println("***********************************************");
        System.out.println("***********************************************");
        System.out.println("***********************************************");


        System.out.println(id);
        holdingRegister.setDevice(deviceService.findById(id));
        holdingRegisterService.save(holdingRegister);
        System.out.println(holdingRegister);

        return "redirect:/";




    }
    @GetMapping("/holdingRegister/del/{id}/{device_id}")
    public String delRegister(
            @PathVariable int id,
            @PathVariable int device_id
    ) {
        holdingRegisterService.delete(id);
        return "redirect:/device/"+device_id;

    }

    }
