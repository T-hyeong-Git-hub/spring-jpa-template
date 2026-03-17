package com.kkth.jpatemplate.domain.member.repository;

import com.kkth.jpatemplate.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom{
}
