package edu.pingpong.quickstart.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {
    
    public String greeting(String name) {
        return "Welcome to the Ethernal Questions " + name;
    }
}
