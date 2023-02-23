package com.sam.helloworld.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {


    @Value("${server1.name}")
    private String n;
    @GetMapping(path = "/")
    public String home(){
        return "Home";
    }
}
