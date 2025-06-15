package com.spring_anas_config.belajar_spring_config_properties.environtment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest(classes = EnvironmentTest.TestEnvironmentConfiguration.class)
public class EnvironmentTest {

    @Autowired
    private Environment environment;

    @Test
    void testEnvirontment(){
        String javaHome = environment.getProperty("JAVA_HOME");
        Assertions.assertEquals("C:\\Program Files\\Java\\jdk-24", javaHome);
        System.out.println(javaHome);
    }

    @SpringBootApplication
    public static class TestEnvironmentConfiguration{

    }

}
