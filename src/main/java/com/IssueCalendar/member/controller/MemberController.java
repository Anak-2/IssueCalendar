package com.IssueCalendar.member.controller;

import com.IssueCalendar.member.domain.Member;
import com.IssueCalendar.member.dto.request.MemberSignup;
import com.IssueCalendar.member.dto.response.MemberResponse;
import com.IssueCalendar.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member/signup")
    public ResponseEntity<MemberResponse> signup(@RequestBody @Valid MemberSignup memberSignup) {
        memberService.checkDuplication(memberSignup);
        Member member = memberService.signup(memberSignup);
        MemberResponse memberResponse = MemberResponse.getFromMember(member);
        return ResponseEntity.ok(memberResponse);
    }
}
