package com.spring_anas_config.belajar_spring_config_properties.profile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = ProfileTest.TestProfileConfiguration.class)
@ActiveProfiles({"local"}) // gunakan annotasi @ActiveProfiles untuk  mengubah profile di unit test.
public class ProfileTest {

    @Autowired
    private TestProfileConfiguration.SayHello sayHello;

    @Test
    void testProfileLocal() {
        Assertions.assertEquals("Hello Joko From Local", sayHello.say("Joko"));
    }

    @SpringBootApplication
    public static class TestProfileConfiguration {

        public interface SayHello {
            public String say(String name);
        }

        @Component
        @Profile({"local"})
        public static class SayHelloLocal implements SayHello {

            @Override
            public String say(String name) {
                return "Hello " + name + " From Local";
            }
        }

        @Component
        @Profile({"production"})
        public static class SayHelProduction implements SayHello {

            @Override
            public String say(String name) {
                return "Hello " + name + " From production";
            }
        }

    }

}
