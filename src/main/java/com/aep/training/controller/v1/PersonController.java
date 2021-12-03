package com.aep.training.controller.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final static Logger logger = LoggerFactory.getLogger(PersonController.class);

    @PostMapping
    public String insert(){
        logger.info("Post a girildi");
        return "Post Sonucu!";
    }

    @GetMapping
    public String retrieve(){
        logger.info("Get e girildi");
        return "GET Sonucu!";
    }

}
