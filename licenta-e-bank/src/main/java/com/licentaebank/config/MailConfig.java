package com.licentaebank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class MailConfig {


    @Bean
    public static JavaMailSenderImpl getMailConfig(){
        JavaMailSenderImpl emailConfig = new JavaMailSenderImpl();

        // Set Properties:
        Properties props = emailConfig.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enabled", "true");
        props.put("mail.debug", "true");


        // Set Mail Credentials:
        emailConfig.setHost("localhost");
        emailConfig.setPort(25);
        emailConfig.setUsername("no-reply@evermint.com");
        emailConfig.setPassword("Welcome_123!");

        return emailConfig;
    }
    // End of Email Config Method
}
