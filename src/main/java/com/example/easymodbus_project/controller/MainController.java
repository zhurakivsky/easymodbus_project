package com.example.easymodbus_project.controller;

import com.example.easymodbus_project.model.*;
import com.example.easymodbus_project.service.*;
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
    private DeviceService deviceService;
    @Autowired
    private HoldingRegisterService holdingRegisterService;
    @Autowired
    private  InputRegisterService inputRegisterService;
    @Autowired
    private CoilsRegisterService coilsRegisterService;
    @Autowired
    private DiscreteRegisterService discreteRegisterService;



    @GetMapping("/")
    public String mainpage (
            Model model){

        List<Device> devices = deviceService.findAll();

        model.addAttribute("devices", devices);

        return "mainpage";
    }
    @GetMapping("/device/{id}")
        public String toDevice(
        @PathVariable int id,
        Model model
    ){
        Device device = deviceService.findById(id);
        model.addAttribute(device);
        List<HoldingRegister> holdingRegisters = device.getHoldingRegisters();
        List<CoilsRegister> coilsRegisters = device.getCoilsRegisters();
        List<InputRegister> inputRegisters = device.getInputRegisters();
        List<DiscreteRegister> discreteRegisters = device.getDiscreteRegisters();
        model.addAttribute("holdingRegisters", holdingRegisters);
        model.addAttribute("coilsRegisters", coilsRegisters);
        model.addAttribute("inputRegisters", inputRegisters );
        model.addAttribute("discreteRegisters", discreteRegisters);
        ModbusClientConnect.ipAddress = device.getIpAddress();
        ModbusClientConnect.port = device.getPort();

        return "device";
    }
    @GetMapping("/createDevice")
    public String createDevice(){
        return "createDevice";
    }

    @GetMapping("/device/del/{id}")
    public String deleteDevice(
            @PathVariable int id
    ){
        deviceService.delete(id);
        return "redirect:/";
    }


    @PostMapping("/addDevice")
    public String addDevice(
            @RequestParam String name,
            @RequestParam String ipAddress,
            @RequestParam int port,
            @RequestParam int quantityHR,
            @RequestParam int quantityCR,
            @RequestParam int quantityDR,
            @RequestParam int quantityIR
    ){

        System.out.println(name);
        Device device = Device.builder().ipAddress(ipAddress).name(name).port(port).quantityCR(quantityCR)
                .quantityDR(quantityDR).quantityHR(quantityHR).quantityIR(quantityIR).build();

        System.out.println(device.getName());
        deviceService.save(device);
        return "redirect:/";

    }
    @PostMapping("/setName")
    public String   setName(
            @RequestBody Device device) {
        Device deviceServiceById = deviceService.findById(device.getId());
        deviceServiceById.setName(device.getName());

        deviceService.save(deviceServiceById);

        return "redirect:/";


    }

    @PostMapping("/setIpAddress")
    public String   setIp(
            @RequestBody Device device){
        Device deviceServiceById = deviceService.findById(device.getId());
        deviceServiceById.setIpAddress(device.getIpAddress());

        deviceService.save(deviceServiceById);

        return "redirect:/";


    }

    @PostMapping("/setPort")
    public String   setPort(
            @RequestBody Device device){
        Device deviceServiceById = deviceService.findById(device.getId());
        deviceServiceById.setPort(device.getPort());

        deviceService.save(deviceServiceById);

        return "redirect:/";


    }
    @PostMapping("/setQuantityHR")
    public String setQuantityHR(
            @RequestBody Device device){

        Device  dev = deviceService.findById(device.getId());
        dev.setQuantityHR(device.getQuantityHR());
        deviceService.save(dev);

        return "redirect:/";
    }@PostMapping("/setQuantityCR")
    public String setQuantityCR(
            @RequestBody Device device){

        Device  dev = deviceService.findById(device.getId());
        dev.setQuantityCR(device.getQuantityCR());
        deviceService.save(dev);


        return "redirect:/";
    }@PostMapping("/setQuantityIR")
    public String setQuantityIR(
            @RequestBody Device device){

        Device  dev = deviceService.findById(device.getId());
        dev.setQuantityIR(device.getQuantityIR());
        deviceService.save(dev);


        return "redirect:/";
    }@PostMapping("/setQuantityDR")
    public String setQuantityDR(
            @RequestBody Device device){

        Device  dev = deviceService.findById(device.getId());
        dev.setQuantityDR(device.getQuantityDR());
        deviceService.save(dev);


        return "redirect:/";
    }

    @GetMapping("/holdingRegister/del/{id}/{device_id}")
    public String delHRegister(
            @PathVariable int id,
            @PathVariable int device_id) {
        holdingRegisterService.delete(id);
        return "redirect:/device/"+device_id;

    }
    @GetMapping("/inputRegister/del/{id}/{device_id}")
    public String delIRegister(
            @PathVariable int id,
            @PathVariable int device_id) {
        inputRegisterService.delete(id);
        return "redirect:/device/"+device_id;

    }

    @GetMapping("/discreteRegister/del/{id}/{device_id}")
    public String delDRegister(
            @PathVariable int id,
            @PathVariable int device_id) {
        discreteRegisterService.delete(id);
        return "redirect:/device/"+device_id;

    }
    @GetMapping("/coilsRegister/del/{id}/{device_id}")
    public String delCRegister(
            @PathVariable int id,
            @PathVariable int device_id) {
        coilsRegisterService.delete(id);
        return "redirect:/device/"+device_id;

    }


    @PostMapping("/device/createHR/{id}")
    public String   createHR(
            @RequestBody HoldingRegister holdingRegister,
            @PathVariable int id) {

        holdingRegister.setDevice(deviceService.findById(id));
        holdingRegisterService.save(holdingRegister);

        return "redirect:/";
    }
    @PostMapping("/device/createIR/{id}")
    public String   createIR(
            @RequestBody InputRegister inputRegister,
            @PathVariable int id) {

        inputRegister.setDevice(deviceService.findById(id));
        inputRegisterService.save(inputRegister);

        return "redirect:/";
    }

    @PostMapping("/device/createCR/{id}")
    public String   createCR(
            @RequestBody CoilsRegister coilsRegister,
            @PathVariable int id) {

        coilsRegister.setDevice(deviceService.findById(id));
        coilsRegisterService.save(coilsRegister);

        return "redirect:/";
    }
    @PostMapping("/device/createDR/{id}")
    public String   createCR(
            @RequestBody DiscreteRegister discreteRegister,
            @PathVariable int id) {

        discreteRegister.setDevice(deviceService.findById(id));
        discreteRegisterService.save(discreteRegister);

        return "redirect:/";
    }


    @PostMapping("/setChanges/coilsRegister")
    public String setChange(
            @RequestBody CoilsRegister coilsRegister
    ){

        String name = coilsRegister.getName();
        int id = coilsRegister.getId();
        CoilsRegister byId = coilsRegisterService.findById(id);
        byId.setName(name);
        coilsRegisterService.save(byId);
        return "redirect:/";

    }
    @PostMapping("/setChanges/discreteRegister")
    public String  setChange(
            @RequestBody DiscreteRegister discreteRegister
    ){

        String name = discreteRegister.getName();
        int id = discreteRegister.getId();
        DiscreteRegister byId = discreteRegisterService.findById(id);
        byId.setName(name);
        discreteRegisterService.save(byId);
        return "redirect:/";

    }

    @PostMapping("/setChanges/inputRegister")
    public String setChange(
            @RequestBody InputRegister inputRegister
    ){

        String name = inputRegister.getName();
        int id = inputRegister.getId();
        InputRegister byId = inputRegisterService.findById(id);
        byId.setName(name);
        inputRegisterService.save(byId);
        return "redirect:/";
    }

    @PostMapping("/setChanges/holdingRegister")
    public String setChange(
            @RequestBody HoldingRegister holdingRegister
    ){

        String name = holdingRegister.getName();
        int maxVal = holdingRegister.getMaxVal();
        int minVal = holdingRegister.getMinVal();
        int id = holdingRegister.getId();
        HoldingRegister byId = holdingRegisterService.findById(id);
        byId.setName(name);
        byId.setMaxVal(maxVal);
        byId.setMinVal(minVal);
        holdingRegisterService.save(byId);
        return "redirect:/";

    }
}