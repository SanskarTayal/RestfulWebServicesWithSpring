package com.twpracticespring.appws.practiceappws.shared;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Component
public class Utils {
    public String getID()
    {
        return String.valueOf(UUID.randomUUID());
    }
}