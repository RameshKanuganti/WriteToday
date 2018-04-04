package com.today.things.util;


import org.springframework.http.HttpStatus;

import static com.today.things.util.Helper.currentTimeStamp;


public class TodayResponse {

    private long timestamp;
    private HttpStatus status;
    private String error;
    private String message;
    private String path;
    private Object resultObject;

    public TodayResponse(HttpStatus status, String error, String message, String path, Object resultObject) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.resultObject = resultObject;
        this.timestamp = currentTimeStamp().getTime();
    }

    public TodayResponse() {
        this.timestamp = currentTimeStamp().getTime();
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Object getResultObject() {
        return resultObject;
    }

    public void setResultObject(Object resultObject) {
        this.resultObject = resultObject;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
