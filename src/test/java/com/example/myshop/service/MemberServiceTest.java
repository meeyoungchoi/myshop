package com.example.myshop.service;

import com.example.myshop.domain.Member;
import com.example.myshop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

//참고 - http://honeymon.io/tech/2018/10/22/spring-boot2-junit5.html
//참고 - https://d2.naver.com/helloworld/1341
//참고 - https://goddaehee.tistory.com/211

@ExtendWith(SpringExtension.class)  //spring으로 부터 확장된 테스트다 스프링과 연동하여 테스트하겠음
@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void 회원가입() {
        // 데이터
        Member member = new Member();
        member.setUsername("hongpark");
        // 동작
        Long memberId = memberService.join(member); // {null, 'hongpark'}
        System.out.println(member.toString());//{1, 'hongpark'}
        // 확인
        assertEquals(member,memberRepository.findOne(memberId)); // serivce에서 join후의 멤버엔티티 객체 , 리파지토리에서 아이디값으로 꺼내온애랑 같ㅌ은가?
        //시점에 따라서 값이 달라진다
        
    }

}