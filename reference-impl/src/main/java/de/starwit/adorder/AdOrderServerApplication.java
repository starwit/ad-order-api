package de.starwit.adorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AdOrderServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdOrderServerApplication.class, args);
    }
}
