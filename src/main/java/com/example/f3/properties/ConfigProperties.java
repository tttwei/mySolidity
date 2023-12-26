package com.example.f3.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties (prefix = "fisco.config")
@Data
public class ConfigProperties {
    private String contractAddress;
    private String peers;
    private String SDKFile;
    private String pemAccountFilePath;


}
