package no.ntnu.webshop.group12.webshop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;

@Configuration
public class ThymeleafConfig {

    @Bean
    SpringSecurityDialect springSecurityDialect() {
        return new SpringSecurityDialect();
    }
}