package com.today.things.serviceI;

import com.today.things.model.TodayUser;

public interface CurrentUserI {

    boolean canAccessUser(TodayUser currentUser, Long userId);

}
