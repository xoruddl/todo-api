package com.example.todo_api.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext // 엔티티 매니지 받음
    private EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }
}
