package com.kkth.jpatemplate.domain.member.repository;

import com.kkth.jpatemplate.domain.member.dto.MemberSearchCondition;
import com.kkth.jpatemplate.domain.member.entity.Member;

import java.util.List;

public interface MemberRepositoryCustom {

    List<Member> searchByName(String name);
    List<Member> search(MemberSearchCondition condition);

}
