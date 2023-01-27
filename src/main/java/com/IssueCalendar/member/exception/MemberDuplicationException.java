package com.IssueCalendar.member.exception;

import com.IssueCalendar.global.error.DuplicationException;
import lombok.Getter;

@Getter
public class MemberDuplicationException extends DuplicationException {

    private static final String MESSAGE = "이미 가입된 회원입니다";

    public MemberDuplicationException() {
        super(MESSAGE);
    }
}
