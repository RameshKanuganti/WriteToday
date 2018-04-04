package com.today.things.serviceImpl;

import com.today.things.dto.ActivityDTO;
import com.today.things.dto.RoleDTO;
import com.today.things.model.Activity;
import com.today.things.model.Role;
import com.today.things.repo.ActivityRepository;
import com.today.things.repo.RoleRepository;
import com.today.things.serviceI.AdminServiceI;
import com.today.things.util.TodayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class AdminService implements AdminServiceI {

    @Autowired
    RoleRepository roleRepository;


    @Autowired
    ActivityRepository activityRepository;

    private MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public TodayResponse getAdminDashBoard() {
        return null;
    }

    @Override
    public TodayResponse saveRole(RoleDTO roleDTO) {
        if (roleDTO != null && roleDTO.getRole() != null) {
            Role role = new Role();
            role.setRole(roleDTO.getRole());
            roleRepository.save(role);
            return new TodayResponse(HttpStatus.CREATED, "", "", "", role);
            /*return new TodayResponse(HttpStatus.CREATED,
                    messageSource.getMessage("today.success.title", null, Locale.US),
                    messageSource.getMessage("today.success.message", null, Locale.US),
                    "", role);*/
        } else {
            return new TodayResponse(HttpStatus.INTERNAL_SERVER_ERROR, "", "", "", null);
        }
    }

    @Override
    public TodayResponse saveActivity(ActivityDTO activityDTO) {
        if (activityDTO != null && activityDTO.getActivityName() != null) {
            Activity activity = new Activity();
            activity.setActivityName(activityDTO.getActivityName());
            activityRepository.save(activity);
            return new TodayResponse(HttpStatus.CREATED, "", "", "", activity);
            /*return new TodayResponse(HttpStatus.CREATED,
                    messageSource.getMessage("today.success", null, Locale.US),
                    messageSource.getMessage("today.success.message", null, Locale.US),
                    "", activity);*/
        } else {
            return new TodayResponse(HttpStatus.INTERNAL_SERVER_ERROR, "", "", "", null);
            /*return new TodayResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                    messageSource.getMessage("today.fail", null, Locale.US),
                    messageSource.getMessage("today.fail.message", null, Locale.US),
                    "", null);*/
        }
    }
}
