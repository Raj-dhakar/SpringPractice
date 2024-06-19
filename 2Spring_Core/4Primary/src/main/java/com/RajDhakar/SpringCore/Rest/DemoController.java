package com.RajDhakar.SpringCore.Rest;

import com.RajDhakar.SpringCore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    @Autowired
    public void setCoach(Coach theCoach){
        myCoach=theCoach;
    }

    @GetMapping("/dailyWorkOut")
    public String dailyWorkOut(){
        return myCoach.getDailyWorkOut();
    }

}
