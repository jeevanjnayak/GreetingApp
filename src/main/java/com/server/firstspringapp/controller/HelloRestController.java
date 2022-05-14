package com.server.firstspringapp.controller;

import com.server.firstspringapp.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloRestController {
    @GetMapping("/")
    public String sayHello() {
        return "Hello Jeevan";
    }

    @RequestMapping(value = {"/rhello"}, method = RequestMethod.GET)
    public String sayHelloDifferently() {

        return "Hello Jeevan";
    }

    @GetMapping("/paramname")
    public String sayPosting(@RequestParam String firstName, @RequestParam String lastName) {

        return "Hello " + firstName + " " + lastName;
    }

    @GetMapping("/{firstName}")
    public String sayHello(@PathVariable String firstName) {
        return "Hello " + firstName;
    }

    @PostMapping("/post")
    public String sayPost(@RequestBody User user) {

        return "Hello " + user.getFirstName() + " " + user.getLastName();
    }

    @PutMapping("/{firstName}")
    public String sayHello(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
        return "Hello " + firstName + " " + lastName;
    }
}
