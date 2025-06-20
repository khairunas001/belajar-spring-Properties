package com.spring_anas_config.belajar_spring_config_properties;

import com.spring_anas_config.belajar_spring_config_properties.converter.StringToDateConverters;
import com.spring_anas_config.belajar_spring_config_properties.properties.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;

@SpringBootApplication
@EnableConfigurationProperties({ApplicationProperties.class})
public class BelajarSpringConfigPropertiesApplication {

    @Bean
    public ConversionService conversionService(StringToDateConverters stringToDateConverters){
        ApplicationConversionService conversionService = new ApplicationConversionService();
        conversionService.addConverter(stringToDateConverters);
        return conversionService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BelajarSpringConfigPropertiesApplication.class, args);
    }

}
