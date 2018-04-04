package com.today.things.util;

import java.sql.Timestamp;
import java.util.Date;

public class Helper {

    public static Timestamp currentTimeStamp() {
        return new Timestamp(new Date().getTime());
    }
}
