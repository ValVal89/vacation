package org.example.controller;

import org.example.model.Dashboard;
import org.example.model.User;
import org.example.repository.DashboardRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4211")
@RestController
@RequestMapping(value = "/dashboard")
public class RestDashboardController {

    @Autowired
    private DashboardRepository dashboardRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/{id}")
    public ResponseEntity<Dashboard> addDashboard(@RequestBody Dashboard dashboard, @PathVariable("id") String id){
        //System.out.println(dashboard);
        //User user = userRepository.findOne(dashboard.getUser().getId());
        User user = userRepository.findOne(id);
        System.out.println(user);
        Dashboard newD = new Dashboard(dashboard.getId(), dashboard.getDescription());
        user.setDashboard(newD.toString());
       // user.getDashboard().setDescription(dashboard.getDescription());
        userRepository.save(user);
       // System.out.println(dashboard);
       //System.out.println(user);
        return new ResponseEntity<Dashboard>(dashboard, HttpStatus.OK);
    }
}
