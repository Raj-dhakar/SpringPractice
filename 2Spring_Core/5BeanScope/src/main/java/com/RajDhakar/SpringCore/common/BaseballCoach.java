package com.RajDhakar.SpringCore.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseballCoach implements Coach{

    @Override
    public String getDailyWorkOut() {
        return "Spend 30 minutes in batting practice";
    }
}
