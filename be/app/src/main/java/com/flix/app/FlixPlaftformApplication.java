package com.flix.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication( scanBasePackages = "com.flix")
public class FlixPlaftformApplication {

    static void main(String[] args) {
        SpringApplication.run(FlixPlaftformApplication.class, args);
    }

}
