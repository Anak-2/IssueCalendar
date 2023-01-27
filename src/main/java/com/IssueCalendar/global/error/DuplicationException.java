package com.IssueCalendar.global.error;

import lombok.Getter;

@Getter
public class DuplicationException extends RuntimeException {

    private String statusCode = "400";

    public DuplicationException(String message) {
        super(message);
    }
}
