package com.cdc.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CdcUserDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CdcUserDemoApplication.class, args);
    }

}
