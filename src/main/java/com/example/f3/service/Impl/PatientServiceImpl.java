package com.example.f3.service.Impl;

import com.example.f3.contract.HospitalCases;
import com.example.f3.entity.PatientInfo;
import com.example.f3.service.PatientService;
import org.fisco.bcos.sdk.model.TransactionReceipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientServiceImpl implements PatientService {
    @Autowired
    private CommonServiceImpl commonService;
    public String addPatient(String address,PatientInfo doctorInfo) throws Exception {
        HospitalCases hospitalCases = commonService.init();
        TransactionReceipt transactionReceipt;
        if (address==null||address.equals("")){
            transactionReceipt = hospitalCases.addPatient(doctorInfo.name,doctorInfo.sex,doctorInfo.sex,doctorInfo.dataBirth);
        }else {
            transactionReceipt = hospitalCases.addPatient(address,doctorInfo.name,doctorInfo.sex,doctorInfo.sex,doctorInfo.dataBirth);
        }

        return transactionReceipt.getStatus();
    }
    public String updatePatient(String address,PatientInfo doctorInfo) throws Exception {
        HospitalCases hospitalCases = commonService.init();
        TransactionReceipt transactionReceipt;
        if (address==null||address.equals("")){
            transactionReceipt = hospitalCases.updatePatient(doctorInfo.name,doctorInfo.sex,doctorInfo.sex,doctorInfo.dataBirth);
        }else {
            transactionReceipt = hospitalCases.updatePatient(address,doctorInfo.name,doctorInfo.sex,doctorInfo.sex,doctorInfo.dataBirth);
        }
        return transactionReceipt.getStatus();
    }

    public HospitalCases.Struct1 query(String addr) throws Exception {
        HospitalCases hospitalCases = commonService.init();
        HospitalCases.Struct1 doctorInfo = hospitalCases.queryPatient(addr);
        return doctorInfo;
    }

}
