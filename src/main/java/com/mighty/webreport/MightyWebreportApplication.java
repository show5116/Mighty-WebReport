package com.mighty.webreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MightyWebreportApplication {

    public static void main(String[] args) {
        SpringApplication.run(MightyWebreportApplication.class, args);
    }

}
