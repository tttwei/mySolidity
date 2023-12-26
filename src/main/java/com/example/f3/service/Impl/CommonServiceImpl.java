package com.example.f3.service.Impl;

import com.example.f3.contract.HospitalCases;
import com.example.f3.properties.ConfigProperties;
import org.fisco.bcos.sdk.BcosSDK;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import utils.ContractUtil;

@Component
public class CommonServiceImpl {

    @Autowired
    private BcosSDK bcosSDK;
    @Autowired
    private ConfigProperties configProperties;


    public HospitalCases init() throws Exception {
        String contractAddress = configProperties.getContractAddress();
        String pemPath = configProperties.getPemAccountFilePath();
        HospitalCases hospitalCases = ContractUtil.contractLoad(bcosSDK,contractAddress,pemPath,HospitalCases.class);
        return hospitalCases;
    }


}
