package com.today.things.serviceImpl;

import com.today.things.dto.ActivityTypeDTO;
import com.today.things.dto.ActivityTypeDetailsDTO;
import com.today.things.dto.RoleDTO;
import com.today.things.dto.UserActivityDTO;
import com.today.things.model.ActivityType;
import com.today.things.model.ActivityTypeDetails;
import com.today.things.model.Role;
import com.today.things.model.UserActivity;
import com.today.things.repo.ActivityTypeDetailRepository;
import com.today.things.repo.ActivityTypeRepository;
import com.today.things.repo.RoleRepository;
import com.today.things.repo.UserActivityRepository;
import com.today.things.serviceI.AdminServiceI;
import com.today.things.util.TodayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class AdminService implements AdminServiceI {

    @Autowired
    RoleRepository roleRepository;


    @Autowired
    UserActivityRepository activityRepository;

    private MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Autowired
    ActivityTypeRepository activityTypeRepository;

    @Autowired
    ActivityTypeDetailRepository activityTypeDetailRepository;

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
            return new TodayResponse(HttpStatus.CREATED,
                    messageSource.getMessage("today.success.title", null, Locale.US),
                    messageSource.getMessage("today.success.message", null, Locale.US),
                    "", role);
        } else {
            return new TodayResponse(HttpStatus.INTERNAL_SERVER_ERROR, "", "", "", null);
        }
    }

    @Override
    public TodayResponse saveActivity(UserActivityDTO activityDTO) {
        if (activityDTO != null && activityDTO.getActivityName() != null) {
            UserActivity activity = new UserActivity();
            activity.setActivityName(activityDTO.getActivityName());
            activityRepository.save(activity);
            return new TodayResponse(HttpStatus.CREATED, "", "", "", null);
            /*return new TodayResponse(HttpStatus.CREATED,
                    messageSource.getMessage("today.success.title", null, Locale.US),
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

    @Override
    public TodayResponse saveActivityType(ActivityTypeDTO activityTypeDTO) {

        if (activityTypeDTO != null && activityTypeDTO.getName() != null) {

            ActivityType activityType = new ActivityType();
            activityType.setName(activityTypeDTO.getName());
            activityTypeRepository.save(activityType);
            return new TodayResponse(HttpStatus.CREATED, "", "", "", activityType);
            /*return new TodayResponse(HttpStatus.CREATED,
                    messageSource.getMessage("today.success.title", null, Locale.US),
                    messageSource.getMessage("today.success.message", null, Locale.US),
                    "", activityType);*/
        } else {
            return new TodayResponse(HttpStatus.INTERNAL_SERVER_ERROR, "", "", "", null);
            /*return new TodayResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                    messageSource.getMessage("today.fail", null, Locale.US),
                    messageSource.getMessage("today.fail.message", null, Locale.US),
                    "", null);*/
        }

    }

    @Override
    public TodayResponse saveActivityTypeDetails(ActivityTypeDetailsDTO activityTypeDetailsDTO) {

        if (activityTypeDetailsDTO != null && activityTypeDetailsDTO.getName() != null) {

            ActivityTypeDetails activityTypeDetails = new ActivityTypeDetails();
            activityTypeDetails.setName(activityTypeDetailsDTO.getName());

            if (activityTypeDetailsDTO.getActivityTypeId() != null && activityTypeDetailsDTO.getActivityTypeId() > 0) {
                ActivityType activityType = activityTypeRepository.findTop1ById(activityTypeDetailsDTO.getActivityTypeId());
                activityTypeDetails.setActivityType(activityType);
            }
            activityTypeDetailRepository.save(activityTypeDetails);
            return new TodayResponse(HttpStatus.CREATED, "", "", "", activityTypeDetails);
        } else {
            return new TodayResponse(HttpStatus.INTERNAL_SERVER_ERROR, "", "", "", null);
        }

    }

    @Override
    public List<ActivityTypeDTO> findAllActivityTypes() {

        List<ActivityType> activityTypeList = activityTypeRepository.findAll();
        List<ActivityTypeDTO> activityTypeDTOList = new ArrayList<>();

        if (activityTypeList != null && activityTypeList.size() > 0) {
            for (ActivityType activityType : activityTypeList) {
                ActivityTypeDTO activityTypeDTO = new ActivityTypeDTO();
                activityTypeDTO.setId(activityType.getId());
                activityTypeDTO.setName(activityType.getName());
                activityTypeDTOList.add(activityTypeDTO);
            }
            return activityTypeDTOList;
        }
        return null;
    }

    @Override
    public List<ActivityTypeDetailsDTO> findAllActivityTypeDetails() {

        List<ActivityTypeDetails> activityTypeDetailsList = activityTypeDetailRepository.findAll();
        List<ActivityTypeDetailsDTO> activityTypeDetailsDTOList = new ArrayList<>();

        if (activityTypeDetailsList != null && activityTypeDetailsList.size() > 0) {
            for (ActivityTypeDetails activityTypeDetails : activityTypeDetailsList) {
                ActivityTypeDetailsDTO activityTypeDetailsDTO = new ActivityTypeDetailsDTO();
                activityTypeDetailsDTO.setId(activityTypeDetails.getId());
                activityTypeDetailsDTO.setName(activityTypeDetails.getName());
                if (activityTypeDetails.getActivityType() != null) {
                    activityTypeDetailsDTO.setActivityType(activityTypeDetails.getActivityType().getName());
                    activityTypeDetailsDTO.setActivityTypeId(activityTypeDetails.getActivityType().getId());
                }
                activityTypeDetailsDTOList.add(activityTypeDetailsDTO);
            }
            return activityTypeDetailsDTOList;
        }
        return null;
    }

}
