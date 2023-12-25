package com.example.f3.service.Impl;

import com.example.f3.contract.HospitalCases;
import com.example.f3.entity.DoctorInfo;
import com.example.f3.service.DoctorService;
import org.fisco.bcos.sdk.model.TransactionReceipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private CommonServiceImpl commonService;
    @Override
    // TODO 判断状态处理
    public String addDoctor(String address, DoctorInfo doctorInfo) throws Exception {
        HospitalCases hospitalCases = commonService.init();
        TransactionReceipt transactionReceipt;
        if (address==null||address.equals("")){
            transactionReceipt = hospitalCases.addDoctor(doctorInfo.getName(), doctorInfo.getSex(), doctorInfo.getAge(), doctorInfo.getWorkYear());
        }else {
            transactionReceipt = hospitalCases.addDoctor(address,doctorInfo.getName(), doctorInfo.getSex(), doctorInfo.getAge(), doctorInfo.getWorkYear());
        }
        String status = transactionReceipt.getStatus();

        return status;
    }
    public String updateDoctor(String address, DoctorInfo doctorInfo) throws Exception {
        HospitalCases hospitalCases = commonService.init();
        TransactionReceipt transactionReceipt;
        if (address==null||address.equals("")){
            transactionReceipt = hospitalCases.updateDoctor(doctorInfo.getName(), doctorInfo.getSex(), doctorInfo.getAge(), doctorInfo.getWorkYear());
        }else {
            transactionReceipt = hospitalCases.updateDoctor(address,doctorInfo.getName(), doctorInfo.getSex(), doctorInfo.getAge(), doctorInfo.getWorkYear());
        }
        return transactionReceipt.getStatus();
    }
    public HospitalCases.Struct0 query(String address) throws Exception {
        HospitalCases hospitalCases = commonService.init();
        HospitalCases.Struct0 doctorInfo;
        if (address == null||address.equals("")) {
            doctorInfo = hospitalCases.queryMySelf();
        }else {
            doctorInfo = hospitalCases.queryDoctor(address);
        }
        return doctorInfo;
    }

    public void del(String addr) throws Exception {
        HospitalCases hospitalCases = commonService.init();
        hospitalCases.delDoctor(addr);
    }


//    public DoctorInfo query(String addr) throws ContractException {
//        HospitalCases hospitalCases = commonService.init();
//        DoctorInfo doctorInfo = hospitalCases.queryDoctor(addr);
//        return doctorInfo;
//    }





}
