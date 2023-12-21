package com.example.f3.config;

import org.fisco.bcos.sdk.BcosSDK;
import org.fisco.bcos.sdk.config.ConfigOption;
import org.fisco.bcos.sdk.config.exceptions.ConfigException;
import org.fisco.bcos.sdk.config.model.ConfigProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class SdkConfig {


    //配置1
    @Bean
    public ConfigProperty defaultConfigProperty() {

        //配置2
        //sdk位置
        ConfigProperty configProperty = new ConfigProperty();
        configProperty.setCryptoMaterial(Collections.singletonMap("certPath", "conf"));

        //工作nodes网络地址
        Map<String, Object> networkMap = new HashMap<>();
        networkMap.put("peers", Arrays.asList("192.168.85.173:20200", "192.168.85.173:20201"));
        configProperty.setNetwork(networkMap);

        //账户配置
        Map<String, Object> accountMap = new HashMap<>();
        accountMap.put("keyStoreDir", "account");
        accountMap.put("accountAddress", "");
        accountMap.put("accountFileFormat", "pem");
        accountMap.put("password", "");
        accountMap.put("accountFilePath", "");
        configProperty.setAccount(accountMap);

        //线程池配置
        Map<String, Object> threadPoolMap = new HashMap<>();
        threadPoolMap.put("channelProcessorThreadSize", "16");
        threadPoolMap.put("receiptProcessorThreadSize", "16");
        threadPoolMap.put("maxBlockingQueueSize", "102400");
        configProperty.setThreadPool(threadPoolMap);
        return configProperty;
    }

    @Bean
    public ConfigOption defaultConfigOption(ConfigProperty configProperty) throws ConfigException {
        return new ConfigOption(configProperty);
    }

    @Bean
    public BcosSDK bcosSDK(ConfigOption configOption) {
        return new BcosSDK(configOption);
    }

}


