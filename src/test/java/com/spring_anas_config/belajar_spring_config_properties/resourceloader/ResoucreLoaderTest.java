package com.spring_anas_config.belajar_spring_config_properties.resourceloader;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@SpringBootTest(classes = ResoucreLoaderTest.TestApplicationResourceLoaderConfiguration.class)
public class ResoucreLoaderTest {

    @Autowired
    private TestApplicationResourceLoaderConfiguration.SampleResource sampleResource;

    @Test
    void testResourceLoader() throws Exception {
        Assertions.assertEquals("anjay namaku bang jago", sampleResource.getText().trim());
        System.out.println(sampleResource.getText().trim());
        System.out.println(sampleResource.getClass());
    }

    @SpringBootApplication
    public static class TestApplicationResourceLoaderConfiguration {

        @Component
        public static class SampleResource implements ResourceLoaderAware {

            @Setter
            private ResourceLoader resourceLoader;

            public String getText() throws Exception {
                Resource resource = resourceLoader.getResource("classpath:/text/resource.txt");
                try (InputStream inputStream = resource.getInputStream()) {
                    return new String(inputStream.readAllBytes());
                }
            }
        }
    }
}
