package org.example.controller;

import org.example.DefaultDashboardSettings;
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

    @DeleteMapping(value = "/{id}")
    public void  deleteUser(@PathVariable("id") String id){
         userRepository.delete(id);
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
    public String getDashboardByUserId(@PathVariable("id") String id){

        String string = userRepository.findOne(id).getDashboard();
        System.out.println("description " + string);
        return string;
        }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        String dashboard = user.getDashboard();
        if (dashboard==null)
        {
           String newDashboard = new DefaultDashboardSettings().getDEFAULT_DASHBOARD();
            System.out.println(newDashboard.substring(newDashboard.indexOf('i'), newDashboard.indexOf(',')));
            user.setDashboard(newDashboard);
        }
        userRepository.save(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") String id){
        String dashboard = user.getDashboard();
        if (dashboard==null)
        {
            String newDashboard = new DefaultDashboardSettings().getDEFAULT_DASHBOARD();
            System.out.println(newDashboard.substring(newDashboard.indexOf('i'), newDashboard.indexOf(',')));
            user.setDashboard(newDashboard);
        }
        userRepository.save(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
