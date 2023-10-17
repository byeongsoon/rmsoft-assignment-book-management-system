package com.rmsoft.bookmanagementsystem.domain.member.repository;

import com.rmsoft.bookmanagementsystem.domain.member.model.Member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByNameAndUserId(final String name, final String userId);

}
