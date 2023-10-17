package com.rmsoft.bookmanagementsystem.domain.member.service;

import com.rmsoft.bookmanagementsystem.domain.member.model.Member;
import com.rmsoft.bookmanagementsystem.domain.member.repository.MemberRepository;
import com.rmsoft.bookmanagementsystem.global.error.exception.BusinessException;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member save(final Member newMember) {
        Optional<Member> findMember = memberRepository.findByNameAndUserId(newMember.getName(), newMember.getUserId());

        if (findMember.isPresent()) {
            throw new BusinessException(409, "이미 존재하는 회원입니다.");
        }

        return memberRepository.save(newMember);
    }

}
