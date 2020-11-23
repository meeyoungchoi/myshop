package com.example.myshop.service;

import com.example.myshop.domain.Member;
import com.example.myshop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {//ctrl shift t test

    @Autowired
    private MemberRepository memberRepository;
    
    /**
    * 회원가입
    * 
    * 
    * */
    public Long join(Member member) {
//        memberRepository.save(member);
        // 회원 아이디 중복방지
        return memberRepository.save(member);
    }

    /**
     * 회원 전체 조회
     *
     * */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    
    /**
     * 회원 단건 조회
     * */
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }




}
