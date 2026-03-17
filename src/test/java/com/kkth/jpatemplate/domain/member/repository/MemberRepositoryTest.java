package com.kkth.jpatemplate.domain.member.repository;

import com.kkth.jpatemplate.domain.member.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
    
    @Test
    public void querydslTest() throws Exception{
        //given
        Member member1 = new Member("kim");
        Member member2 = new Member("lee");

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> searchMember = memberRepository.searchByName("kim");

        //then
        Assertions.assertThat(searchMember.size()).isEqualTo(1);
    }
}