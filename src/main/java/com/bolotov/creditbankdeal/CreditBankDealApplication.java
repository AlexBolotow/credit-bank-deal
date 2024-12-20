package com.bolotov.creditbankdeal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CreditBankDealApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditBankDealApplication.class, args);
    }

}
