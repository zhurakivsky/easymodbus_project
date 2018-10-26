package com.example.easymodbus_project.model;


import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@EqualsAndHashCode
@Entity
@ToString (exclude = "device")
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class InputRegister  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int address;
    private int value;
    private String name;

    @ManyToOne(
//            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Device device;




}