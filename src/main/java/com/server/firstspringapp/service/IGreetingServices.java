package com.server.firstspringapp.service;

import com.server.firstspringapp.model.User;

import java.util.List;
import java.util.Optional;

public interface IGreetingServices {
    User addGreeting(User user);
    User getGreetingById(int id);

    String sayHelloByName(String firstName, String lastName);

    User sayHello(User user);

    Optional<User> sayHelloById(int id);

    List<User> sayHelloAll();

    String deleteById(int id);
}
