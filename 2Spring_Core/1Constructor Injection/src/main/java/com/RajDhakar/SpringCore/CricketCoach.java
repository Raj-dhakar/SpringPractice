package com.RajDhakar.SpringCore;

import org.springframework.stereotype.Component;

@Component // Make it available as spring bean
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkOut() {
        return "Practice fast bowling for 15 minutes!";
    }
}
