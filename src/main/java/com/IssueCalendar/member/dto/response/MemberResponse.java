package com.IssueCalendar.member.dto.response;

import com.IssueCalendar.member.domain.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberResponse {

    private String identifier;

    private String name;

    private String email;

    private String password;

    public MemberResponse(String identifier, String name, String email, String password) {
        this.identifier = identifier;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static MemberResponse getFromMember(Member member) {
        return MemberResponse.builder()
                .identifier(member.getIdentifier())
                .name(member.getName())
                .email(member.getEmail())
                .password(member.getPassword())
                .build();
    }
}
