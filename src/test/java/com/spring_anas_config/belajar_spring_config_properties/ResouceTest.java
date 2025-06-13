package com.spring_anas_config.belajar_spring_config_properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class ResouceTest {

    @Test
    void testResource() throws IOException {
        var resource = new ClassPathResource("/text/mabar.txt");

        Assertions.assertNotNull(resource);
        Assertions.assertTrue(resource.exists());
        Assertions.assertNotNull(resource.getFile());

        System.out.println(resource.getPath());
        System.out.println(resource.getFilename());
        System.out.println(resource.getFile().getAbsolutePath());
    }
}
