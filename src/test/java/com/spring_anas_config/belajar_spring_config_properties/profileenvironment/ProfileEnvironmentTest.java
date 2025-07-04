package com.spring_anas_config.belajar_spring_config_properties.profileenvironment;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

@SpringBootTest(classes = ProfileEnvironmentTest.TestProfileEnvironmentConfiguration.class)
@ActiveProfiles({"local","production"})
public class ProfileEnvironmentTest {

    @Autowired
    private TestProfileEnvironmentConfiguration.SampleProfile sampleProfile;

    @Test
    void testActiveProfiles(){
        Assertions.assertArrayEquals(new String[]{"local", "production"}, sampleProfile.getProfiles());
        System.out.println(Arrays.toString(sampleProfile.getProfiles()));
    }

    @SpringBootApplication
    public static class TestProfileEnvironmentConfiguration{

        @Component
        public static class SampleProfile implements EnvironmentAware{

            @Setter
            private Environment environment;

            public String[] getProfiles(){
                return environment.getActiveProfiles();
            }

        }
    }

}
