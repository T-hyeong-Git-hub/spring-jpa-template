package com.kkth.jpatemplate.domain.member.repository;

import com.kkth.jpatemplate.domain.member.dto.MemberSearchCondition;
import com.kkth.jpatemplate.domain.member.entity.Member;
import com.kkth.jpatemplate.domain.member.entity.QMember;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
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

    @Override
    public List<Member> search(MemberSearchCondition condition) {
        QMember qMember = member;
        return queryFactory
                .selectFrom(member)
                .where(
                        nameEq(condition.getName()),
                        createdAfter(condition.getCreatedAt())
                )
                .fetch();
    }

    private BooleanExpression nameEq(String name) {
        return name != null ? QMember.member.name.eq(name) : null;
    }

    private BooleanExpression createdAfter(LocalDateTime createdAt) {
        return createdAt != null ? QMember.member.createdAt.goe(createdAt) : null;
    }
}
