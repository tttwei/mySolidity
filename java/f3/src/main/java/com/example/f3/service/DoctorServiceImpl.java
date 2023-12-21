package com.example.f3.service;

import com.example.f3.contract.HospitalCases;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorServiceImpl {
    @Autowired
    private CommonServiceImpl commonService;
    public void addDoctor(HospitalCases.DoctorInfo doctorInfo) throws ContractException {
        HospitalCases hospitalCases = commonService.init();
        hospitalCases.addDoctor(doctorInfo);
    }
    public void updateDoctor(HospitalCases.DoctorInfo doctorInfo) throws ContractException {
        HospitalCases hospitalCases = commonService.init();
        hospitalCases.updateDoctor(doctorInfo);
    }
    public HospitalCases.DoctorInfo queryMySelf() throws ContractException {
        HospitalCases hospitalCases = commonService.init();
        HospitalCases.DoctorInfo doctorInfo = hospitalCases.queryMySelf();
        return doctorInfo;
    }
    public HospitalCases.DoctorInfo query(String addr) throws ContractException {
        HospitalCases hospitalCases = commonService.init();
        HospitalCases.DoctorInfo doctorInfo = hospitalCases.queryDoctor(addr);
        return doctorInfo;
    }





}
