package com.spring_anas_config.belajar_spring_config_properties.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter

// jadi ini digunakan untuk binding properties, jadi kita tidak perlu manual menggunakan annotasi @Value
@ConfigurationProperties("application") // dan dengan annotasi ini bisa langsung mengenerate ke file metadata
public class ApplicationProperties {

    private Date expireDate;

    private Duration defaultTimeout;

    private String name; // jadi ini akan sama dengan dengan "application.name"

    private Integer version; // jadi ini akan sama dengan dengan "application.version"

    // pada penamaan variabe dibawah ini jika menggunakan productionMode akan dibuat dimeta data menjadi production-mode
    private boolean productionMode; // jadi ini akan sama dengan dengan "application.production-mode"

    private DatabaseProperties database;  // jadi ini akan sama dengan dengan "application.database"

    private List<Role> defaultRoles;

    // <String (datanya yang berupa string),
    // Role(key-nya yang bernilai admin dll, sesuai settingan pada application.properties)>
    private Map<String, Role> roles;

    @Getter
    @Setter
    public static class DatabaseProperties{

        private String username; // jadi ini akan sama dengan dengan "application.database.username"

        private String password; // jadi ini akan sama dengan dengan "application.database.password"

        private String database; // jadi ini akan sama dengan dengan "application.database.database"

        private String url; // jadi ini akan sama dengan dengan "application.database.url"

        private List<String> whiteListTable;

        //<String (untuk key-nya yaitu setelah max-table-size adalah products/customers/categoriese),
        // Integer(adalah nilai dari key-nya)>
        private Map<String, Integer> maxTableSize;
    }

    @Getter
    @Setter
    public static class Role {

        private String id;

        private String name;

    }

}
