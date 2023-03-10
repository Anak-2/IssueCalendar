package com.IssueCalendar.member.repository;

import com.IssueCalendar.member.domain.Member;

import java.util.Optional;

public interface MemberRepository {

    void save(Member member);

    Optional<Member> findByIdentifier(String identifier);
}
