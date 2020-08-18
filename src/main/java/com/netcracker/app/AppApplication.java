package com.netcracker.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

/*    @Bean
    CommandLineRunner runner(MobileRepository mobileRepository) {
        return args -> {
            mobileRepository.save(new Mobile(500, 500, 450, "Profitable", "some text"));
        };
    }*/
}
