package com.today.things.serviceImpl;

import com.today.things.model.TodayUser;
import com.today.things.serviceI.CurrentUserI;
import com.today.things.util.Constants;

public class CurrentUserService implements CurrentUserI {
    @Override
    public boolean canAccessUser(TodayUser currentUser, Long userId) {

        if (currentUser != null) {
            return (currentUser.getRoles().get(0).getRole() == Constants.getRole.getStateValue(Constants.getRole.ADMIN) || currentUser.getId().equals(userId));
        } else {
            return false;
        }
    }
}
