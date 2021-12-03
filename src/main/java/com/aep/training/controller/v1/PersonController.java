package com.aep.training.controller.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @PostMapping
    public String insert(){
        return "Post Sonucu!";
    }

    @GetMapping
    public String retrieve(){
        return "GET Sonucu!";
    }

}
