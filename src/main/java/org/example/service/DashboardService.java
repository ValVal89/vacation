package org.example.service;

import org.example.model.Dashboard;
import org.example.model.User;
import org.example.repository.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    @Autowired
    private DashboardRepository dashboardRepository;

    public Dashboard getDashboard(User user){
        return dashboardRepository.findByUser_Id(user.getId());
    }
}
