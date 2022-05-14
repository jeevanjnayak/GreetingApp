package com.server.firstspringapp.service;

import com.server.firstspringapp.model.User;
import com.server.firstspringapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingServices implements IGreetingServices{
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public User addGreeting(User user) {
        String message = String.format(template,(user.toString().isEmpty()) ? "Hello World" : user.toString());
        return greetingRepository.save(new User(counter.incrementAndGet(), message));
    }

    @Override
    public User getGreetingById(int id) {
        return greetingRepository.findById(id).get();
    }
    public String sayHelloByName(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName + "!!!";
    }

    public User sayHello(User user) {
        User newUser = new User(user);
        greetingRepository.save(user);
        return newUser;
    }

    public Optional<User> sayHelloById(int id) {
        return greetingRepository.findById(id);

    }
    public List<User> sayHelloAll(){
        return greetingRepository.findAll();

    }
    public String deleteById(int id) {
        greetingRepository.deleteById(id);
        return "User by id "+id+" is Deleted";
    }
}
