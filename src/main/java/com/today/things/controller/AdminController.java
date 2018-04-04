package com.today.things.controller;

import com.today.things.dto.ActivityDTO;
import com.today.things.dto.RoleDTO;
import com.today.things.model.Activity;
import com.today.things.model.Role;
import com.today.things.repo.ActivityRepository;
import com.today.things.repo.RoleRepository;
import com.today.things.serviceI.AdminServiceI;
import com.today.things.util.TodayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    AdminServiceI adminServiceI;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ActivityRepository activityRepository;

    /*@RequestMapping("/")
    private ResponseEntity<TodayResponse> getAdminDashBoard() {
        TodayResponse todayResponse = adminServiceI.getAdminDashBoard();
        return new ResponseEntity<TodayResponse>(todayResponse, todayResponse.getStatus());
    }*/

    @RequestMapping(value = {"/role", "/"}, method = RequestMethod.GET)
    public String addRoles(Model model) {
        List<Role> roles = roleRepository.findAll();
        model.addAttribute("rolesList", roles);
        return "add_role";
    }

    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public String saveRoles(@ModelAttribute RoleDTO roleDTO, Model model) {
        TodayResponse todayResponse = adminServiceI.saveRole(roleDTO);

        model.addAttribute("result", todayResponse);
        List<Role> roles = roleRepository.findAll();
        model.addAttribute("rolesList", roles);

        return "add_role";
    }

    @RequestMapping(value = "/activity", method = RequestMethod.GET)
    public String viewActivities(Model model) {
        List<Activity> activities = activityRepository.findAll();
        model.addAttribute("activityList", activities);

        return "activity";
    }

    @RequestMapping(value = "/activity", method = RequestMethod.POST)
    public String addActivity(@ModelAttribute ActivityDTO activityDTO, Model model) {
        TodayResponse todayResponse = adminServiceI.saveActivity(activityDTO);

        List<Activity> activities = activityRepository.findAll();
        model.addAttribute("activityList", activities);

        return "activity";
    }


}
