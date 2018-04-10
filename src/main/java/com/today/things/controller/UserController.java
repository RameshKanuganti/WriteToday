package com.today.things.controller;

import com.today.things.dto.UserDTO;
import com.today.things.model.UserActivity;
import com.today.things.repo.UserActivityRepository;
import com.today.things.serviceI.UserServiceI;
import com.today.things.util.TodayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserServiceI userServiceI;

    @Autowired
    UserActivityRepository activityRepository;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerUser(@ModelAttribute UserDTO userDTO) {

        return "sign_up";

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute UserDTO userDTO) {

        TodayResponse todayResponse = userServiceI.register(userDTO);
        return "sign_up";

    }


    @RequestMapping(value = "user_activity", method = RequestMethod.GET)
    public String userActivityGet(Model model, @ModelAttribute UserDTO userDTO) {

        List<UserActivity> activities = activityRepository.findAll();
        model.addAttribute("activityList", activities);
        return "user_activity";
    }

    @RequestMapping(value = "user_activity", method = RequestMethod.POST)
    public String userActivity(Model model, @ModelAttribute UserDTO userDTO) {

        List<UserActivity> activities = activityRepository.findAll();
        model.addAttribute("activityList", activities);
        return "user_activity";
    }


}
