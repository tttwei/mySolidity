package com.example.f3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cases {
    private String _patient;
    private String _appointmentType;
    private String _appointmentTime;
    private String _description;
    private String _prescription;
    private String _money;


}
