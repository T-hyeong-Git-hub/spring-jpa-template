package com.kkth.jpatemplate.domain.member.repository;

import com.kkth.jpatemplate.domain.member.entity.Member;
import com.kkth.jpatemplate.domain.member.entity.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.kkth.jpatemplate.domain.member.entity.QMember.member;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{
    private final JPAQueryFactory queryFactory;

//    public MemberRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
//        this.jpaQueryFactory = jpaQueryFactory;
//    }

    @Override
    public List<Member> searchByName(String name) {
        QMember qMember = member;

        return queryFactory
                .selectFrom(member)
                .where(member.name.eq(name))
                .fetch();
    }
}
