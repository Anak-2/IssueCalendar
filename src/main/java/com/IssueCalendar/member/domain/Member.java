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

    private String id;

    private String name;

    private String email;

    private String password;

    @Builder
    public Member(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static Member getFromMemberSignup(MemberSignup memberSignup) {
        return Member.builder()
                .id(memberSignup.getId())
                .name(memberSignup.getName())
                .email(memberSignup.getEmail())
                .password(memberSignup.getPassword())
                .build();
    }
}
