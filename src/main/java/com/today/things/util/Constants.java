package com.today.things.util;

public interface Constants {

    enum getRole {
        USER, ADMIN;

        public static String getStateValue(getRole role) {
            switch (role) {
                case USER:
                    return "USER";
                case ADMIN:
                    return "ADMIN";
                default:
                    return "Unregistered List";
            }
        }
    }
}
