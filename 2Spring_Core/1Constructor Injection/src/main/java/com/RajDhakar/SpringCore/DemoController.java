package com.RajDhakar.SpringCore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    @Autowired
    public DemoController(Coach myCoach){
        this.myCoach=myCoach;
    }

    @GetMapping("/dailyWorkOut")
    public String dailyWorkOut(){
        return myCoach.getDailyWorkOut();
    }

}
