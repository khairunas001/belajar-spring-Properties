package com.spring_anas_config.belajar_spring_config_properties.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter

// jadi ini digunakan untuk binding properties, jadi kita tidak perlu manual menggunakan annotasi @Value
@ConfigurationProperties("application") // dan dengan annotasi ini bisa langsung mengenerate ke file metadata
public class ApplicationProperties {

    private String name; // jadi ini akan sama dengan dengan "application.name"

    private Integer version; // jadi ini akan sama dengan dengan "application.version"

    // pada penamaan variabe dibawah ini jika menggunakan productionMode akan dibuat dimeta data menjadi production-mode
    private boolean productionMode; // jadi ini akan sama dengan dengan "application.production-mode"

    private DatabaseProperties database;  // jadi ini akan sama dengan dengan "application.database"

    @Getter
    @Setter
    public static class DatabaseProperties{

        private String username; // jadi ini akan sama dengan dengan "application.database.username"

        private String password; // jadi ini akan sama dengan dengan "application.database.password"

        private String database; // jadi ini akan sama dengan dengan "application.database.database"

        private String url; // jadi ini akan sama dengan dengan "application.database.url"
    }

}
