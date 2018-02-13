package org.example.repository;

import org.example.model.Dashboard;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Set;

public interface DashboardRepository extends MongoRepository<Dashboard, String> {
    Dashboard findByUser_Id(String userId);
}
