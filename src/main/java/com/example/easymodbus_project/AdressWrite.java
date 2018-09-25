package com.example.easymodbus_project;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Data
public class AdressWrite {

    public int start;
    public int value;

    public AdressWrite(int start, int value) {
        this.start = start;
        this.value = value;
    }
}
