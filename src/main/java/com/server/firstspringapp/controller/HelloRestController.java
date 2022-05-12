package com.server.firstspringapp.controller;

import com.server.firstspringapp.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloRestController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Everyone";
    }

    @RequestMapping(value = {"/hello-w"}, method = RequestMethod.GET)
    public String sayHelloDifferently() {

        return "Hello Everyone";
    }

    @GetMapping("/hello/query")
    public String sayPosting(@RequestParam String firstName, @RequestParam String lastName) {

        return "Hello " + firstName + " " + lastName;
    }

    @GetMapping("/hello/{firstName}")
    public String sayHello(@PathVariable String firstName) {
        return "Hello " + firstName;
    }

    @PostMapping("/hello/post")
    public String sayPost(@RequestBody User user) {

        return "Hello " + user.getFirstName() + " " + user.getLastName();
    }

    @PutMapping("/hello/{firstName}")
    public String sayHello(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
        return "Hello " + firstName + " " + lastName;
    }
}
