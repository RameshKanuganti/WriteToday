package com.today.things.serviceI;

import com.today.things.dto.ActivityQuestionDTO;
import com.today.things.dto.ActivityTypeDTO;
import com.today.things.dto.ActivityTypeDetailsDTO;
import com.today.things.dto.RoleDTO;
import com.today.things.util.TodayResponse;

import java.util.List;

public interface AdminServiceI {

    TodayResponse getAdminDashBoard();

    TodayResponse saveRole(RoleDTO roleDTO);

    TodayResponse saveActivity(ActivityQuestionDTO activityDTO);

    TodayResponse saveActivityType(ActivityTypeDTO activityTypeDTO);

    TodayResponse saveActivityTypeDetails(ActivityTypeDetailsDTO activityTypeDetailsDTO);

    List<ActivityTypeDTO> findAllActivityTypes();

    List<ActivityTypeDetailsDTO> findAllActivityTypeDetails();

    List<ActivityQuestionDTO> findAllActivityQuestions();

}
