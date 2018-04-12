package com.today.things.controller;

import com.today.things.dto.ActivityActionLogDTO;
import com.today.things.dto.UserDTO;
import com.today.things.repo.ActivityQuestionRepository;
import com.today.things.serviceI.AdminServiceI;
import com.today.things.serviceI.UserServiceI;
import com.today.things.util.TodayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    UserServiceI userServiceI;

    @Autowired
    AdminServiceI adminServiceI;

    @Autowired
    ActivityQuestionRepository activityRepository;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerUser(@ModelAttribute UserDTO userDTO) {
        return "sign_up";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute UserDTO userDTO) {

        TodayResponse todayResponse = userServiceI.register(userDTO);
        return "sign_up";

    }

    @RequestMapping(value = "user_activity_action", method = RequestMethod.GET)
    public String userActivityGet(Model model, @ModelAttribute UserDTO userDTO) {

        model.addAttribute("activityQuestionDTOList", adminServiceI.findAllActivityQuestions());
        model.addAttribute("activityTypeList", adminServiceI.findAllActivityTypes());
        model.addAttribute("activityTypeDetailsList", adminServiceI.findAllActivityTypeDetails());

        return "activity_action_log_by_user";
    }

    @RequestMapping(value = "user_activity_action", method = RequestMethod.POST)
    public String userActivity(Model model, @ModelAttribute ActivityActionLogDTO activityActionLogDTO) {

        TodayResponse todayResponse = userServiceI.saveActivityLog(activityActionLogDTO);

        model.addAttribute("activityQuestionDTOList", adminServiceI.findAllActivityQuestions());
        model.addAttribute("activityTypeList", adminServiceI.findAllActivityTypes());
        model.addAttribute("activityTypeDetailsList", adminServiceI.findAllActivityTypeDetails());
        return "activity_action_log_by_user";
    }


}
