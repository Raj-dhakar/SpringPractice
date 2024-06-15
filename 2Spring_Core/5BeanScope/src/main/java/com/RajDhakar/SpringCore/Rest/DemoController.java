package com.RajDhakar.SpringCore.Rest;

import com.RajDhakar.SpringCore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public void setCoach(@Qualifier("baseballCoach") Coach theCoach,
                         @Qualifier("baseballCoach") Coach theCoach2){
        myCoach=theCoach;
        anotherCoach=theCoach2;
    }

    @GetMapping("/dailyWorkOut")
    public String dailyWorkOut(){
        return myCoach.getDailyWorkOut();
    }

    @GetMapping("/check")
    public String check(){
        return "Coparing beans mycoach==anothercoach = "+(myCoach==anotherCoach);
    }
}
