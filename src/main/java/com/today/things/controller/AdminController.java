package com.today.things.controller;

import com.today.things.dto.ActivityQuestionDTO;
import com.today.things.dto.ActivityTypeDTO;
import com.today.things.dto.ActivityTypeDetailsDTO;
import com.today.things.dto.RoleDTO;
import com.today.things.model.ActivityType;
import com.today.things.model.Role;
import com.today.things.repo.ActivityQuestionRepository;
import com.today.things.repo.ActivityTypeDetailRepository;
import com.today.things.repo.ActivityTypeRepository;
import com.today.things.repo.RoleRepository;
import com.today.things.serviceI.AdminServiceI;
import com.today.things.util.TodayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    AdminServiceI adminServiceI;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ActivityQuestionRepository userActivityRepository;

    @Autowired
    ActivityTypeRepository activityTypeRepository;

    @Autowired
    ActivityTypeDetailRepository activityTypeDetailRepository;

    @GetMapping("/")
    private String getAdminDashBoard() {
        //TodayResponse todayResponse = adminServiceI.getAdminDashBoard();
        //return new ResponseEntity<TodayResponse>(todayResponse, todayResponse.getStatus());
        return "sign_up";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = {"/role"}, method = RequestMethod.GET)
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

    @RequestMapping(value = "activity_type", method = RequestMethod.GET)
    private String showActivityType(Model model) {

        List<ActivityType> activities = activityTypeRepository.findAll();
        model.addAttribute("activityTypeList", activities);
        return "activity_type";
    }

    @RequestMapping(value = "activity_type", method = RequestMethod.POST)
    private String saveActivityType(@ModelAttribute ActivityTypeDTO activityTypeDTO, Model model) {
        TodayResponse todayResponse = adminServiceI.saveActivityType(activityTypeDTO);

        List<ActivityType> activities = activityTypeRepository.findAll();
        model.addAttribute("activityTypeList", activities);
        return "activity_type";
    }

    @RequestMapping(value = "activity_type_details", method = RequestMethod.GET)
    private String showActivityTypeDetails(Model model) {

        model.addAttribute("activityTypeList", adminServiceI.findAllActivityTypes());
        model.addAttribute("activityTypeDetailsList", adminServiceI.findAllActivityTypeDetails());
        return "activity_type_details";
    }

    @RequestMapping(value = "activity_type_details", method = RequestMethod.POST)
    private String saveActivityTypeDetails(@ModelAttribute ActivityTypeDetailsDTO activityTypeDetailsDTO, Model model) {
        TodayResponse todayResponse = adminServiceI.saveActivityTypeDetails(activityTypeDetailsDTO);

        model.addAttribute("activityTypeList", adminServiceI.findAllActivityTypes());
        model.addAttribute("activityTypeDetailsList", adminServiceI.findAllActivityTypeDetails());
        return "activity_type_details";
    }

    @RequestMapping(value = "/activity_question", method = RequestMethod.GET)
    public String viewActivities(Model model) {

        List<ActivityQuestionDTO> activityQuestionDTOList = adminServiceI.findAllActivityQuestions();
        model.addAttribute("activityQuestionDTOList", activityQuestionDTOList);

        List<ActivityTypeDTO> activityTypeList = adminServiceI.findAllActivityTypes();
        model.addAttribute("activityTypeList", activityTypeList);

        return "activity_question";
    }

    @RequestMapping(value = "/activity_question", method = RequestMethod.POST)
    public String addActivity(@ModelAttribute ActivityQuestionDTO activityDTO, Model model) {
        TodayResponse todayResponse = adminServiceI.saveActivity(activityDTO);

        List<ActivityQuestionDTO> activityQuestionDTOList = adminServiceI.findAllActivityQuestions();
        model.addAttribute("activityQuestionDTOList", activityQuestionDTOList);

        List<ActivityTypeDTO> activityTypeList = adminServiceI.findAllActivityTypes();
        model.addAttribute("activityTypeList", activityTypeList);

        return "activity_question";
    }

}
