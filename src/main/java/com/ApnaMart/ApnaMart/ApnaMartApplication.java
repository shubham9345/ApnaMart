package com.ApnaMart.ApnaMart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ApnaMart.ApnaMart.Repository")
@EntityScan(basePackages = "com.ApnaMart.ApnaMart.Model")
@EnableWebSecurity
public class ApnaMartApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApnaMartApplication.class, args);
    }

}