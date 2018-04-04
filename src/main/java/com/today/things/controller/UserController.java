package com.today.things.controller;

import com.today.things.dto.UserDTO;
import com.today.things.serviceI.UserServiceI;
import com.today.things.util.TodayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    UserServiceI userServiceI;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerUser(@ModelAttribute UserDTO userDTO) {

        return "sign_up";

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute UserDTO userDTO) {

        TodayResponse todayResponse = userServiceI.register(userDTO);
        return "sign_up";

    }
}
