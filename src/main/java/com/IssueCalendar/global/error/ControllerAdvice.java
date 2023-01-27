package com.IssueCalendar.global.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.*;

@RestController
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException e) {

        ErrorResponse errorResponse = ErrorResponse.builder()
                .statusCode("400")
                .message("잘못된 요청입니다")
                .build();

        return ResponseEntity.status(BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(DuplicationException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> duplicationException(DuplicationException e) {

        ErrorResponse errorResponse = ErrorResponse.builder()
                .statusCode(e.getStatusCode())
                .message(e.getMessage())
                .build();

        return ResponseEntity.status(BAD_REQUEST).body(errorResponse);
    }
}
