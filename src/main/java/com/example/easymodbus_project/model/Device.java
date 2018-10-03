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
    private String ipadress;
    private int port;




    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "device"
    )
    private List<CoilsRegistr> coilsRegistr;
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "device"
    )
    private List<DigitalRegistr> digitalRegistr;
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "device"
    )
    private List<HoldingRegistr> holdingRegistr;
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "device"
    )
    private List<InputRegistr> inputRegistr;



}
