package com.spring_anas_config.belajar_spring_config_properties.springbootmessagesource;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@SpringBootTest(classes = SpringBootMessageSourceTest.TestSpringBootMessageSourceConfiguration.class)
public class SpringBootMessageSourceTest {

    @Autowired
    private TestSpringBootMessageSourceConfiguration.SampleSource sampleSource;

    @Test
    void testHelloJoko() {
        Assertions.assertEquals("Hello Wiwok-Detox", sampleSource.haloJoko(Locale.ENGLISH));
        Assertions.assertEquals("Halo Wiwok-Detox", sampleSource.haloJoko(new Locale("in_ID")));
    }

    @SpringBootApplication
    public static class TestSpringBootMessageSourceConfiguration {

        @Component
        public static class SampleSource implements MessageSourceAware {

            @Setter
            private MessageSource messageSource;

            public String haloJoko(Locale locale) {
                return messageSource.getMessage("hello", new Object[]{"Wiwok-Detox"}, locale);
            }

        }
    }
}
