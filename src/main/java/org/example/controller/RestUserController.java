package org.example.controller;

import org.example.model.Dashboard;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4211")
@RestController
@RequestMapping("/users")
public class RestUserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable("id") String id){
        User user = userRepository.findOne(id);
        System.out.println("USER" + user);
        return user;
    }

   /* @GetMapping(value = "/{id}/dashboard")
    public String getDashboardDescription(@PathVariable("id") String id){
        String string = userRepository.findOne(id).getDashboard().getDescription();
        System.out.println("description " + string);
        return string;
    }*/

    @GetMapping(value = "/{id}/dashboard")
    public String getDashboard(@PathVariable("id") String id){
        String string = userRepository.findOne(id).getDashboard();
        System.out.println("description " + string);
        return string;
    }

    @PostMapping
    public ResponseEntity<User> addNewEmployee(@RequestBody User employee){
        userRepository.save(employee);
        return new ResponseEntity<User>(employee, HttpStatus.OK);
    }
}
