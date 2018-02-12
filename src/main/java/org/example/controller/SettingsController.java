package org.example.controller;

import org.example.model.Settings;
import org.example.model.User;
import org.example.repository.SettingsRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/settings")
public class SettingsController {

    @Autowired
    private SettingsRepository settingsRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Settings> addSettings(@RequestBody Settings settings){
        System.out.println(settings);
        User user = userRepository.findByFirstName("Valentina");
        user.getSettings().add(settings);
        userRepository.save(user);
        System.out.println(settings);
        System.out.println(user);
        return new ResponseEntity<Settings>(settings, HttpStatus.OK);
    }
}
