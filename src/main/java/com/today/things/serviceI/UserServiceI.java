package com.today.things.serviceI;

import com.today.things.dto.ActivityActionLogDTO;
import com.today.things.dto.UserDTO;
import com.today.things.util.TodayResponse;

public interface UserServiceI {
    TodayResponse register(UserDTO userDTO);

    TodayResponse saveActivityLog(ActivityActionLogDTO activityActionLogDTO);

}
