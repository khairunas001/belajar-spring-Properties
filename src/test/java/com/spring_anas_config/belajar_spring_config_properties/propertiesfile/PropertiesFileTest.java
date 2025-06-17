package com.spring_anas_config.belajar_spring_config_properties.propertiesfile;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = PropertiesFileTest.TestPropertiesFilCOnfiguration.class)
@ActiveProfiles({"production", "test"})
public class PropertiesFileTest {

    @Autowired
    private TestPropertiesFilCOnfiguration.ProfileProperties profileProperties;

    @Test
    void testPropertiesFile(){
        Assertions.assertEquals("Default", profileProperties.getDefaultValue());
        Assertions.assertEquals("Production", profileProperties.getProductionFile());
        Assertions.assertEquals("Test", profileProperties.getTestFile());
    }

    @SpringBootApplication
    public static class TestPropertiesFilCOnfiguration {

        @Component
        @Getter
        public static class ProfileProperties {

            @Value("${profiles.default}")
            private String defaultValue;

            @Value("${profiles.production}")
            private String productionFile;

            @Value("${profiles.test}")
            private String testFile;
        }
    }
}
