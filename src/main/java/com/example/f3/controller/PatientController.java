package com.example.f3.controller;

import com.example.f3.contract.HospitalCases;
import com.example.f3.entity.PatientInfo;
import com.example.f3.entity.R;
import com.example.f3.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping({"/add/{address}", "/add"})
    public R add(@PathVariable String address , @RequestBody PatientInfo patientInfo) throws Exception {
        patientService.addPatient(address,patientInfo);
        return R.success();
    }
    @PutMapping({"/update/{address}", "/update"})
    public R update(@PathVariable String address , PatientInfo doctorInfo) throws Exception {
        patientService.updatePatient(address,doctorInfo);
        return R.success();
    }

    @GetMapping
    public R<HospitalCases.Struct1> query(String address) throws Exception {
        HospitalCases.Struct1 patient = patientService.query(address);
        return R.success(patient);
    }
}
