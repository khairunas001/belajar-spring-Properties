package com.spring_anas_config.belajar_spring_config_properties.value;



import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

@SpringBootTest(classes = ValueTest.TestValueConfiguration.class)
public class ValueTest {

    @Autowired
    private TestValueConfiguration.ApplicationProperties properties;

    @Autowired
    private TestValueConfiguration.SystemProperties systemProperties;

    @Test
    void testApplicationProperties(){
        Assertions.assertEquals("Belajar Spring Boot", properties.getName());
        Assertions.assertEquals(1, properties.getVersion());
        Assertions.assertEquals(false, properties.isProductionMode());
        Assertions.assertFalse(properties.isProductionMode());
    }

    @Test
    void TestSystemProperties(){
        Assertions.assertEquals("C:\\Program Files\\Java\\jdk-24", systemProperties.getJavaHome());
    }

    @SpringBootApplication
    public static class TestValueConfiguration{

        @Component
        @Getter
        public static class SystemProperties{
            @Value("${JAVA_HOME}")
            private String javaHome;
        }


        @Component
        @Getter
        public static class ApplicationProperties{

            @Value("${application.name}")
            private String name;

            @Value("${application.version}")
            private Integer version;

            @Value("${application.production-mode}")
            private boolean productionMode;

        }
    }
}
