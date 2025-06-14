package com.spring_anas_config.belajar_spring_config_properties.messagesource;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public class MessageSourceTest {

    private ApplicationContext applicationContext;
    private MessageSource messageSource;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(TestMessageSourceConfiguration.class);
        messageSource = applicationContext.getBean(MessageSource.class);
    }

    @Test
    void testDefaultLocale(){
        String message = messageSource.getMessage("hello", new Object[]{"Jokondo-kondo"}, Locale.ENGLISH);
        Assertions.assertEquals("Hello Jokondo-kondo", message);
    }

    @Test
    void testIndonesiaLocale(){
        String message = messageSource.getMessage("halo", new Object[]{"Wiwok-Detox"}, new Locale("in_ID"));
        Assertions.assertEquals("Halo Wiwok-Detox", message);
    }

    @SpringBootApplication
    public static class TestMessageSourceConfiguration {

        @Bean
        public MessageSource messageSource() {
            ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
            messageSource.setBasenames("my");
            return messageSource;
        }
    }

}
