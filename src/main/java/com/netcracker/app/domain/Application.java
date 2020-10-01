package com.netcracker.app.domain;

import com.netcracker.app.domain.info.entities.contacts.ContactsImpl;
import com.netcracker.app.domain.info.services.contacts.ContactsServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
