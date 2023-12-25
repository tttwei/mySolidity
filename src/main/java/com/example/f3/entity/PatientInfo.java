package com.example.f3.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
public class PatientInfo implements Serializable {

    public String name;

    public BigInteger sex;

    public BigInteger age;

    public BigInteger theType;

    public String dataBirth;
}
