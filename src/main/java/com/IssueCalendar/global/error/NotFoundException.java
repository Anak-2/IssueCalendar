package com.IssueCalendar.global.error;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    private String statusCode = "404";

    public NotFoundException(String message) {
        super(message);
    }
}
