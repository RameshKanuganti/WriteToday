package com.today.things.controller;

import com.today.things.serviceI.HomeServiceI;
import com.today.things.util.TodayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

    @Autowired
    HomeServiceI homeServiceI;

    /*private ResponseEntity<TodayResponse> getHomePage() {
        TodayResponse todayResponse = homeServiceI.getHomePage();
        return new ResponseEntity<TodayResponse>(todayResponse, todayResponse.getStatus());
    }*/

}
