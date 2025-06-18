package com.spring_anas_config.belajar_spring_config_properties.applicationproperties;


import com.spring_anas_config.belajar_spring_config_properties.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ApplicationPropertiesTest.TestApplicationPropertiesConfiguration.class)
public class ApplicationPropertiesTest {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Test
    void testApplicationProperties() {
        Assertions.assertEquals("Belajar Spring Boot", applicationProperties.getName());
        Assertions.assertEquals(1, applicationProperties.getVersion());
        Assertions.assertEquals(false, applicationProperties.isProductionMode());
    }

    @Test
    void testDatabaseProperties(){
        Assertions.assertEquals("joko", applicationProperties.getDatabase().getUsername());
        Assertions.assertEquals("detox", applicationProperties.getDatabase().getPassword());
        Assertions.assertEquals("belajar", applicationProperties.getDatabase().getDatabase());
        Assertions.assertEquals("jdbc:contoh", applicationProperties.getDatabase().getUrl());
    }

    @SpringBootTest
    @EnableConfigurationProperties({ApplicationProperties.class})
    public static class TestApplicationPropertiesConfiguration {

    }

}
