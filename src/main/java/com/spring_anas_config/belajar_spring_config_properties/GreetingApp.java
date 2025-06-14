package com.spring_anas_config.belajar_spring_config_properties;

import java.util.Locale;
import java.util.ResourceBundle;

public class GreetingApp {
    public static void main(String[] args) {
        //gabutmu
        Locale indonesia = new Locale("id"); // sudah tidak berlaku sejak v19
        ResourceBundle bundle = ResourceBundle.getBundle("messages", indonesia); //"messages" disini adalah nama dari file propertiesnys

        String greet = bundle.getString("greeting"); //"greeting" adalah key dari file propertiesnya
        System.out.println(greet); // Output: Halo!

        // gabutku
        Locale gabut = new Locale("en");
        ResourceBundle bundle2 = ResourceBundle.getBundle("application", gabut);

        String greet2 = bundle2.getString("spring.application.name");
        System.out.println(greet2); // Output: Halo!
    }
}
