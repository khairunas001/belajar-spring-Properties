package com.spring_anas_config.belajar_spring_config_properties.appproperties;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest(classes = ApplicationPropertiesTest.TestsApplicationPropertiesConfiguration.class)
public class ApplicationPropertiesTest {

    @Autowired
    private Environment environment;

    @Test
    void testApplicationProperties(){
        String environmentProperty = environment.getProperty("application.name");
        Assertions.assertEquals("Belajar Spring Boot", environmentProperty);
        System.out.println(environmentProperty);
    }

    @SpringBootApplication
    public static class TestsApplicationPropertiesConfiguration{

    }
}
