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


public class InputRegistr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private int adress;
    private int value;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Device device;




}