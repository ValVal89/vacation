package org.example;

import org.example.model.Settings;
import org.example.model.User;
import org.example.repository.SettingsRepository;
import org.example.repository.UserRepository;
import org.example.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
