package com.spring_anas_config.belajar_spring_config_properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PemangkatanTest {

    private ConfigurableApplicationContext applicationContext;
    private Pemangkatan pemangkatan;

    @BeforeEach
    void setUp() {
        pemangkatan = new Pemangkatan();
        applicationContext = new AnnotationConfigApplicationContext(Pemangkatan.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testPangkat() {
        int pangkat = pemangkatan.pangkat(20);

        Assertions.assertEquals(20 * 20, pangkat);
    }
}
