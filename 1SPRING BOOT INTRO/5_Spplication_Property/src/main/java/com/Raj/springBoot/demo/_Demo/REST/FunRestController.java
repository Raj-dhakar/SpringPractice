package com.Raj.springBoot.demo._Demo.REST;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // Inject property for coach.name and team.name

    @Value("${coach.name}")
    private String CoachName;

    @Value("${team.name}")
    private String TeamName;

    @GetMapping("/teamInfo")
    public String teamInfo(){
        return "CoachName is:"+CoachName+" ans TeamName is:"+TeamName;
    }

    @GetMapping("/")
    public String sayHello(){
        return "Hello world";
    }

    @GetMapping("/workout")
    public String getDailyworkout(){
        return "Run a hard 5k!";
    }
}
