package com.example.f3.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
public class DoctorInfo implements Serializable {
    // 姓名
    private String name;
    // 性别
    private BigInteger sex;
    // 年龄
    private BigInteger age;
    //类型 1是医生 2是病人
    private BigInteger theType;
    //工龄
    private BigInteger workYear;
}
