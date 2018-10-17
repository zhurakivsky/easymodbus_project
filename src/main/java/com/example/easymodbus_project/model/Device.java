package com.example.easymodbus_project.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@ToString (exclude = {"coilsRegistr","digitalRegistr","holdingRegistr", "inputRegistr"})
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String ipAddress;
    private int port;




    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "device"
    )
    private List<CoilsRegister> coilsRegisters;
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "device"
    )
    private List<DiscreteRegister> discreteRegisters;
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "device"
    )
    private List<HoldingRegister> holdingRegisters;
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "device"
    )
    private List<InputRegister> inputRegisters;



}
