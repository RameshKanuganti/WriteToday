package com.today.things.serviceI;

import com.today.things.dto.ActivityDTO;
import com.today.things.dto.RoleDTO;
import com.today.things.util.TodayResponse;

public interface AdminServiceI {

    TodayResponse getAdminDashBoard();

    TodayResponse saveRole(RoleDTO roleDTO);

    TodayResponse saveActivity(ActivityDTO activityDTO);
}
