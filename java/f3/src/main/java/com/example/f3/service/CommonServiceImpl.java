package com.example.f3.service;

import com.example.f3.contract.HospitalCases;
import org.fisco.bcos.sdk.BcosSDK;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import utils.ContractUtil;

@Component
@ConfigurationProperties(prefix = "fisco.user.address")
public class CommonServiceImpl {

    @Autowired
    private BcosSDK bcosSDK;

    public static final String address="0xed19e8abbe61bbf57ed5393d3434aa620b7afc47";

    public HospitalCases init() throws ContractException {

        HospitalCases hospitalCases = ContractUtil.contractLoad(bcosSDK,address);
        return hospitalCases;
    }


}
