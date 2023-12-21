package com.example.f3.controller;

import com.example.f3.contract.HospitalCases;
import com.example.f3.entity.R;
import com.example.f3.service.DoctorServiceImpl;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorServiceImpl doctorService;

    @PostMapping("/add")
    public R add(@RequestBody HospitalCases.DoctorInfo doctorInfo) throws ContractException {
        doctorService.addDoctor(doctorInfo);
        return R.success();
    }
    @PutMapping("/update")
    public R update(HospitalCases.DoctorInfo doctorInfo) throws ContractException {
        doctorService.updateDoctor(doctorInfo);
        return R.success();
    }
    @GetMapping
    public R<HospitalCases.DoctorInfo> queryMyself() throws ContractException {
        HospitalCases.DoctorInfo doctorInfo = doctorService.queryMySelf();
        return R.success(doctorInfo);
    }

    @GetMapping("/{address}")
    public R<HospitalCases.DoctorInfo> query(@PathVariable String address) throws ContractException {
        HospitalCases.DoctorInfo doctorInfo = doctorService.query(address);
        return R.success(doctorInfo);
    }

}
