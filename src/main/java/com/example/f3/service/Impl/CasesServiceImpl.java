package com.example.f3.service.Impl;

import com.example.f3.contract.HospitalCases;
import com.example.f3.entity.Cases;
import com.example.f3.service.Impl.CommonServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.sdk.model.TransactionReceipt;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CasesServiceImpl {
    @Autowired
    private CommonServiceImpl commonService;

    /**
     * 添加病例
     * @param cases
     * @throws ContractException
     */
    public TransactionReceipt  addCases(Cases cases) throws Exception {
        HospitalCases hospitalCases = commonService.init();
        TransactionReceipt transactionReceipt = hospitalCases.addCases(cases.get_patient(), cases.get_appointmentType(),
                cases.get_appointmentTime(), cases.get_description(), cases.get_prescription(), cases.get_money());

        log.info("case的数据,{},{},{},{},{},{}",cases.get_patient(),cases.get_appointmentType(),
                cases.get_appointmentTime(),cases.get_description(),cases.get_prescription(),cases.get_money());
        return transactionReceipt;
    }

//    public DynamicArray<HospitalCases.Cases> queryCases(String address) throws ContractException {
//        HospitalCases hospitalCases = commonService.init();
//        DynamicArray<HospitalCases.Cases> casesDynamicArray = hospitalCases.queryCases(address);
//        return casesDynamicArray;
//    }



}
