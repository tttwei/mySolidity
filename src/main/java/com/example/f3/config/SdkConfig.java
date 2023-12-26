package com.example.f3.config;

import com.example.f3.properties.ConfigProperties;
import org.fisco.bcos.sdk.BcosSDK;
import org.fisco.bcos.sdk.config.ConfigOption;
import org.fisco.bcos.sdk.config.exceptions.ConfigException;
import org.fisco.bcos.sdk.config.model.ConfigProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class SdkConfig {
    @Autowired
    private ConfigProperties configProperties;

    @Bean
    public ConfigProperty defaultConfigProperty() {
        //sdk位置
        ConfigProperty configProperty = new ConfigProperty();
        configProperty.setCryptoMaterial(Collections.singletonMap("certPath", configProperties.getSDKFile()));

        //工作nodes网络地址
        Map<String, Object> networkMap = new HashMap<>();
        networkMap.put("peers", Arrays.asList(configProperties.getPeers()));
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


