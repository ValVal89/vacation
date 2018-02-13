package org.example.repository;

import org.example.model.Dashboard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository extends MongoRepository<Dashboard, String> {
    Dashboard findByUser_Id(String userId);
}
