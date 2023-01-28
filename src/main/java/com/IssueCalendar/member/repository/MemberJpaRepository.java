package com.IssueCalendar.member.repository;

import com.IssueCalendar.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByIdentifier(String identifier);
}
