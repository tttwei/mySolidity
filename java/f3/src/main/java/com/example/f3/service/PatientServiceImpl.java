package com.example.f3.service;

import com.example.f3.contract.HospitalCases;
import org.fisco.bcos.sdk.model.TransactionReceipt;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientServiceImpl {
    @Autowired
    private CommonServiceImpl commonService;
    public TransactionReceipt addPatient(HospitalCases.PatientInfo doctorInfo) throws ContractException {
        HospitalCases hospitalCases = commonService.init();
        TransactionReceipt transactionReceipt = hospitalCases.addPatient(doctorInfo);
        return transactionReceipt;
    }
    public void updatePatient(HospitalCases.PatientInfo doctorInfo) throws ContractException {
        HospitalCases hospitalCases = commonService.init();
        hospitalCases.updatePatient(doctorInfo);
    }

    public HospitalCases.PatientInfo query(String addr) throws ContractException {
        HospitalCases hospitalCases = commonService.init();
        HospitalCases.PatientInfo doctorInfo = hospitalCases.queryPatient(addr);
        return doctorInfo;
    }
}
