package com.kkth.jpatemplate.domain.member.repository;

import com.kkth.jpatemplate.domain.member.entity.Member;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Member> searchByName(String name);

}
