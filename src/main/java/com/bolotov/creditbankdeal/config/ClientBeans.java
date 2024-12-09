package com.bolotov.creditbankdeal.config;

import com.bolotov.creditbankdeal.client.RestClientCalculatorRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientBeans {

    @Bean
    public RestClientCalculatorRestClient calculatorRestClient(
            @Value("${credit-bank.services.calculator.base.uri:http://localhost:8081}") String calculatorBaseUri) {
        return new RestClientCalculatorRestClient(RestClient.builder()
                .baseUrl(calculatorBaseUri)
                .build()
        );
    }
}
