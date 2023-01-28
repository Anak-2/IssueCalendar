package com.IssueCalendar.member.dto.request;

import lombok.Getter;

@Getter
public class MemberSignup {

    private String identifier;

    private String name;

    private String email;

    private String password;
}
