package com.kkth.jpatemplate.domain.member.repository;

import com.kkth.jpatemplate.domain.member.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;
    @Test
    public void memberSave() throws Exception{
        Member member = new Member("kim");

        memberRepository.save(member);
        Member findMember = memberRepository.findAll().get(0);

        System.out.println("createdAt = " + findMember.getCreatedAt());
        System.out.println("updatedAt = " + findMember.getUpdatedAt());

    }
}