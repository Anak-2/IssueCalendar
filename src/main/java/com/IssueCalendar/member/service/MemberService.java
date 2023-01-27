package com.IssueCalendar.member.service;

import com.IssueCalendar.member.domain.Member;
import com.IssueCalendar.member.dto.request.MemberSignup;
import com.IssueCalendar.member.exception.MemberDuplicationException;
import com.IssueCalendar.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public Member signup(MemberSignup memberSignup) {
        Member member = Member.getFromMemberSignup(memberSignup);
        memberRepository.save(member);
        return member;
    }

    public void checkDuplication(MemberSignup memberSignup) {
        Optional<Member> member = memberRepository.findById(memberSignup.getId());
        if (member.isPresent()) {
            throw new MemberDuplicationException();
        }
    }
}
