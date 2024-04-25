package com.twpracticespring.appws.practiceappws.ui.model.respomse;

import java.util.Date;

public class ErrorMessageForException {
    Date timestamp;
    String message;
    public ErrorMessageForException(){}

    public ErrorMessageForException(Date timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
