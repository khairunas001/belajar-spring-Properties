package com.spring_anas_config.belajar_spring_config_properties.testpropertysource;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;

// jika properti pada unit test maka menggunakan Annnotasi @TestPropertySources dan @TestPropertySource
// sehingga kita bisa menggunakan properties yang lain untuk melakukan unit test
@TestPropertySources({
        @TestPropertySource("classpath:/test.properties")
})
@SpringBootTest(classes = PropertySourceTest.TestPropertySourceConfiguration.class)
public class PropertySourceTest {

    @Autowired
    private TestPropertySourceConfiguration.SampleProperties sampleProperties;

    @Test
    void testPropertySource(){
        Assertions.assertEquals("Sample Project Test", sampleProperties.getName());
        System.out.println("✅ nilai dari sample.name sesuai"+ sampleProperties.getName());
        Assertions.assertEquals(1, sampleProperties.getVersion());
        System.out.println("✅ nilai dari sample.version sesuai"+ sampleProperties.getVersion());
    }

    @SpringBootApplication
    public static class TestPropertySourceConfiguration {

        @Component
        @Getter
        public static class SampleProperties {

            @Value("${sample.name}")
            private String name;

            @Value("${sample.version}")
            private Integer version;
        }
    }
}
