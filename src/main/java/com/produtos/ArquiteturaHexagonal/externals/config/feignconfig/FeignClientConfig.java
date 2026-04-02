package com.produtos.ArquiteturaHexagonal.externals.config.feignconfig;

import com.produtos.ArquiteturaHexagonal.externals.security.interceptor.FeignAuthInterceptor;
import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Configuration
public class FeignClientConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

            if (attributes != null) {
                String authorizationHeader = attributes.getRequest().getHeader("Authorization");
                if (authorizationHeader != null) {
                    // Repassa o Header Authorization (Bearer Token) integralmente
                    requestTemplate.header("Authorization", authorizationHeader);
                }
            }
        };
    }
}
