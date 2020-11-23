package com.example.myshop.repository;

import com.example.myshop.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MemberRepository {

    @Autowired
    private EntityManager em;//디비에저장하고 꺼내올수있다

    // 생성
    public Long save(Member member) {
        //참고 - https://ict-nroo.tistory.com/130
        //질문 member의 id가 null일경우 db에 저장되고 null이 아니면 update가 실행되는 것인가?
        //질문 CrudRepository의 save()도 같은 원리로 동작하는것인가?
        em.persist(member); // member 객체를 db에 반영 연결이된다 그러므로 값이 있게된다
        //member객체에는 id값이 null인데 디비에 member가 저장되면 id값이 생긴다
        //id값이 member객체이도 연결이된다
        //https://doublesprogramming.tistory.com/259
        //https://engkimbs.tistory.com/832
        return member.getId();
    }

    //조회
    public Member findOne(Long memberId) {
        // Member found = em.find(Member.class, memberId);//반환타입이 member타입이다
        return em.find(Member.class, memberId);
    }


    public List<Member> findAll() {
        //jpql(java persist query language) sql을 닮은 jpa쿼리
//        List<Member> members = em.createQuery(
//                "select m from Member m",
//                Member.class
//        ).getResultList();
        //참고 - https://victorydntmd.tistory.com/205
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }


    //수정

    //삭제
}
