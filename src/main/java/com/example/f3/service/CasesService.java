package com.example.f3.service;

import com.example.f3.contract.HospitalCases;
import com.example.f3.entity.Cases;

import java.util.List;

public interface CasesService {
    String addCases(Cases cases) throws Exception;
    List<HospitalCases.Struct2> query(String address) throws Exception;
}
