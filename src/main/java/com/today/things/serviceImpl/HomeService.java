package com.today.things.serviceImpl;

import com.today.things.serviceI.HomeServiceI;
import com.today.things.util.TodayResponse;
import org.springframework.stereotype.Service;

@Service
public class HomeService implements HomeServiceI {
    @Override
    public TodayResponse getHomePage() {
        return null;
    }
}
