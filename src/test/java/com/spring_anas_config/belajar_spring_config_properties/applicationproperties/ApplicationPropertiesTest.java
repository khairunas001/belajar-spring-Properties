package com.spring_anas_config.belajar_spring_config_properties.applicationproperties;


import com.spring_anas_config.belajar_spring_config_properties.converter.StringToDateConverters;
import com.spring_anas_config.belajar_spring_config_properties.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;

@SpringBootTest(classes = ApplicationPropertiesTest.TestApplicationPropertiesConfiguration.class)
public class ApplicationPropertiesTest {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private ConversionService conversionService;

    @Test
    void testConversionService() {
        var expireDate = applicationProperties.getExpireDate();
        var dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Assertions.assertTrue(conversionService.canConvert(String.class, Integer.class));
        Assertions.assertTrue(conversionService.canConvert(String.class, Date.class));

        Assertions.assertEquals(Duration.ofSeconds(10), conversionService.convert("10s", Duration.class));
        Assertions.assertEquals("01-12-2001", dateFormat.format(expireDate));
    }

    @Test
    void testApplicationProperties() {
        Assertions.assertEquals("Belajar Spring Boot", applicationProperties.getName());
        Assertions.assertEquals(1, applicationProperties.getVersion());
        Assertions.assertEquals(false, applicationProperties.isProductionMode());
    }

    @Test
    void testDatabaseProperties() {
        Assertions.assertEquals("joko", applicationProperties.getDatabase().getUsername());
        Assertions.assertEquals("detox", applicationProperties.getDatabase().getPassword());
        Assertions.assertEquals("belajar", applicationProperties.getDatabase().getDatabase());
        Assertions.assertEquals("jdbc:contoh", applicationProperties.getDatabase().getUrl());
    }

    @Test
    void testCollectionProperties() {
        Assertions.assertEquals(Arrays.asList("products", "customers", "categories"), applicationProperties.getDatabase().getWhiteListTable());
        Assertions.assertEquals(100, applicationProperties.getDatabase().getMaxTableSize().get("products"));
        Assertions.assertEquals(100, applicationProperties.getDatabase().getMaxTableSize().get("customers"));
        Assertions.assertEquals(100, applicationProperties.getDatabase().getMaxTableSize().get("categories"));
        System.out.println(applicationProperties);
        System.out.println(applicationProperties.getDatabase());
        System.out.println(applicationProperties.getDatabase().getMaxTableSize());
    }

    @Test
    void testEmbeddedCollection() {
        Assertions.assertEquals("default", applicationProperties.getDefaultRoles().get(0).getId());
        Assertions.assertEquals("Default Role", applicationProperties.getDefaultRoles().get(0).getName());
        Assertions.assertEquals("guest", applicationProperties.getDefaultRoles().get(1).getId());
        Assertions.assertEquals("Guest Role", applicationProperties.getDefaultRoles().get(1).getName());
        System.out.println(applicationProperties.getDefaultRoles());

        Assertions.assertEquals("admin", applicationProperties.getRoles().get("admin").getId());
        Assertions.assertEquals("Admin Role", applicationProperties.getRoles().get("admin").getName());
        Assertions.assertEquals("finance", applicationProperties.getRoles().get("finance").getId());
        Assertions.assertEquals("Finance Role", applicationProperties.getRoles().get("finance").getName());
        System.out.println(applicationProperties.getRoles());
    }

    @Test
    void testDurationProperties() {
        Assertions.assertEquals(Duration.ofSeconds(10), applicationProperties.getDefaultTimeout());
    }

    @Test
    void testCustomConverter() {
        Date expireDate = applicationProperties.getExpireDate();

        var dateFormat = new SimpleDateFormat("yyy-MM-dd");
        Assertions.assertEquals("2001-12-01", dateFormat.format(expireDate));

    }

    @SpringBootTest
    @EnableConfigurationProperties({ApplicationProperties.class})
    @Import(StringToDateConverters.class)
    public static class TestApplicationPropertiesConfiguration {

        @Bean
        public ConversionService conversionService(StringToDateConverters stringToDateConverters) {
            ApplicationConversionService conversionService = new ApplicationConversionService();
            conversionService.addConverter(stringToDateConverters);
            return conversionService;
        }

    }

}
