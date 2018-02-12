package org.example.service;

import org.example.model.Settings;
import org.example.model.User;
import org.example.repository.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class SettingsService {
    @Autowired
    private SettingsRepository settingsRepository;

    public Set<Settings> getUserSettings(User user){
        return settingsRepository.findByUser_Id(user.getId());
    }
}
