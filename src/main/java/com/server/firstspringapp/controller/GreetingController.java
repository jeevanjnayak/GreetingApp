package com.server.firstspringapp.controller;

import com.server.firstspringapp.model.User;
import com.server.firstspringapp.service.IGreetingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
    @Autowired
    private IGreetingServices greetingService;

    @GetMapping("/hello")
    public String sayPosting(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        if (lastName == null) lastName = "";
        else if (firstName == null) firstName = "";
        else if (firstName == null && lastName == null) {
            firstName = "";
            lastName = "";
        }
        return greetingService.sayHelloByName(firstName, lastName);
    }
    @PostMapping("/post")
    public User sayHello (@RequestBody User user){
        return greetingService.sayHello(user);
    }
    @GetMapping("/user/{id}")
    public Optional<User> sayHelloById (@PathVariable int id){
        Optional<User> response = greetingService.sayHelloById(id);
        return response;
    }
    @GetMapping("/users")
    public List<User> sayHelloToAll (){
        List<User> response = greetingService.sayHelloAll();
        return response;
    }
    @DeleteMapping ("/user/{id}")
    public String  deleteUser (@PathVariable int id){
        String response = greetingService.deleteById(id);
        return response;
    }
}
