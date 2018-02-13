package org.example.controller;

import org.example.model.Dashboard;
import org.example.model.User;
import org.example.repository.DashboardRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/dashboard")
public class RestDashboardController {

    @Autowired
    private DashboardRepository dashboardRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Dashboard> addDashboard(@RequestBody Dashboard dashboard){
        //System.out.println(dashboard);
        User user = userRepository.findByFirstName("Marta");
        //System.out.println(user);
        Dashboard newD = new Dashboard(dashboard.getId(), dashboard.getDescription());
        user.setDashboard(newD);
       // user.getDashboard().setDescription(dashboard.getDescription());
        userRepository.save(user);
       // System.out.println(dashboard);
       //System.out.println(user);
        return new ResponseEntity<Dashboard>(dashboard, HttpStatus.OK);
    }
}
