package com.spring_anas_config.belajar_spring_config_properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaLoggingGbt {
    private static final Logger logger = LoggerFactory.getLogger(JavaLoggingGbt.class);

    public void doSomething() {
        logger.info("Aplikasi dimulai");
        logger.debug("Debug detail untuk proses");
        logger.warn("Peringatan: Sesuatu mencurigakan");
        logger.error("Terjadi error");
    }

    public static void main(String[] args) {
        JavaLoggingGbt javaLoggingGbt = new JavaLoggingGbt();

        javaLoggingGbt.doSomething();
    }

}
