package com.example.f3.service;

import com.example.f3.contract.HospitalCases;
import com.example.f3.entity.DoctorInfo;

public interface DoctorService {
    String addDoctor(String address, DoctorInfo doctorInfo) throws Exception;

    String updateDoctor(String address, DoctorInfo doctorInfo) throws Exception;
    HospitalCases.Struct0 query(String address) throws Exception;
    void del(String addr) throws Exception;
}
