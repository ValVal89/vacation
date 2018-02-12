package org.example.repository;

import org.example.model.Settings;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Set;

public interface SettingsRepository extends MongoRepository<Settings, String> {
    Set<Settings> findByUser_Id(Long userId);
}
