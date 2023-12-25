package com.example.f3.service.Impl;

import com.example.f3.contract.HospitalCases;
import org.fisco.bcos.sdk.BcosSDK;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import utils.ContractUtil;

@Component
//@ConfigurationProperties(prefix = "fisco.user.address")
public class CommonServiceImpl {

    @Autowired
    private BcosSDK bcosSDK;

    public static final String address="0xddf703028d07316b5510835d94fee72c1e9795fa";

    public HospitalCases init() throws Exception {

        HospitalCases hospitalCases = ContractUtil.contractLoad(bcosSDK,address, HospitalCases.class);
        return hospitalCases;
    }


}
