package com.example.f3.controller;

import com.example.f3.contract.HospitalCases;
import com.example.f3.entity.R;
import com.example.f3.service.PatientServiceImpl;
import org.fisco.bcos.sdk.model.TransactionReceipt;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientServiceImpl patientService;

    @PostMapping("/add")
    public R add(@RequestBody HospitalCases.PatientInfo patientInfo) throws ContractException {
        TransactionReceipt transactionReceipt = patientService.addPatient(patientInfo);
        return R.success(transactionReceipt);
    }
    @PutMapping("/update")
    public R update(HospitalCases.PatientInfo doctorInfo) throws ContractException {
        patientService.updatePatient(doctorInfo);
        return R.success();
    }

    @GetMapping("/{address}")
    public R<HospitalCases.PatientInfo> query(@PathVariable String address) throws ContractException {
        HospitalCases.PatientInfo doctorInfo = patientService.query(address);
        return R.success(doctorInfo);
    }
}
