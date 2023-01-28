package com.IssueCalendar.member.domain;

import com.IssueCalendar.member.dto.request.MemberSignup;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_no")
    private Long memberNo;

    private String identifier;

    private String name;

    private String email;

    private String password;

    @Builder
    public Member(String identifier, String name, String email, String password) {
        this.identifier = identifier;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static Member getFromMemberSignup(MemberSignup memberSignup) {
        return Member.builder()
                .identifier(memberSignup.getIdentifier())
                .name(memberSignup.getName())
                .email(memberSignup.getEmail())
                .password(memberSignup.getPassword())
                .build();
    }
}
