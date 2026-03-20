\# Spring Boot JPA + QueryDSL Template



\## 📌 프로젝트 소개



JPA 기반 프로젝트를 진행할 때 반복되는 설정과 구조를 줄이기 위해

\*\*Spring Boot + JPA + QueryDSL 템플릿 프로젝트\*\*를 구축하였습니다.



이 템플릿은 이후 다양한 도메인 프로젝트에서 재사용하는 것을 목표로 합니다.



\---



\## 🛠 기술 스택



\* Java 21

\* Spring Boot 3.x

\* Spring Data JPA

\* QueryDSL

\* H2 Database

\* Gradle



\---



\## 📂 프로젝트 구조



```

domain

&#x20;└ member

&#x20;     ├ entity

&#x20;     │    └ Member

&#x20;     │

&#x20;     ├ dto

&#x20;     │    ├ MemberSearchCondition

&#x20;     │    └ MemberDto

&#x20;     │

&#x20;     ├ repository

&#x20;     │    ├ MemberRepository

&#x20;     │    ├ MemberRepositoryCustom

&#x20;     │    └ MemberRepositoryImpl

&#x20;     │

&#x20;     └ service



global

&#x20;└ entity

&#x20;     └ BaseEntity



config

&#x20;└ QuerydslConfig

```



\---



\## 🧑‍💻 주요 기능



\### 1. JPA 기본 설정



\* Spring Data JPA 기반 CRUD

\* `BaseEntity`를 통한 공통 필드 관리



&#x20; \* createdAt

&#x20; \* updatedAt

\* Auditing 적용



\---



\### 2. QueryDSL 환경 구성



\* QClass 자동 생성

\* `JPAQueryFactory` Bean 등록

\* 타입 세이프 쿼리 작성 가능



\---



\### 3. 동적 쿼리



\* `BooleanExpression` 활용

\* 조건 메서드 분리

\* null-safe where 절 구성



```java

.where(

&#x20;   nameEq(condition.getName()),

&#x20;   createdAfter(condition.getCreatedAt())

)

```



\---



\### 4. 페이징 처리



\* `Pageable` 기반 조회

\* `offset`, `limit` 적용

\* countQuery 분리



```java

.offset(pageable.getOffset())

.limit(pageable.getPageSize())

```



\---



\### 5. DTO 조회



\* `Projections.constructor` 사용

\* 필요한 컬럼만 조회



```java

.select(Projections.constructor(

&#x20;   MemberDto.class,

&#x20;   member.id,

&#x20;   member.name

))

```



\---



\## 🎯 개발 목적



\* JPA + QueryDSL 기본 구조 템플릿화

\* 반복적인 설정 제거

\* 실무에서 바로 사용할 수 있는 기반 구축



\---



\## 📌 향후 계획



\* 도메인 기반 프로젝트 적용 (예약 시스템 등)

\* 공통 응답 구조 추가

\* 예외 처리 구조 추가

\* QueryDSL 공통 유틸화

\* Service 레이어 확장



\---



\## 💡 참고



본 프로젝트는 학습과 실무 적용을 동시에 고려하여

점진적으로 개선해 나갈 예정입니다.



