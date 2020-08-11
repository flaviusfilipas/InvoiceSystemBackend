package com.invoicesystem.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "application.jwt")
@Component
public class JwtProperties {
    private String secretKey;
}
