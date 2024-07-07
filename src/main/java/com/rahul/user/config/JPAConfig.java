package com.rahul.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.rahul.user.repository.jpa")
@EnableTransactionManagement
public class JPAConfig {
    // Any additional JPA-specific configuration can go here
}