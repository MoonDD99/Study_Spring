package com.study_spring.studyspring.service;

import com.study_spring.studyspring.domain.Member;
import com.study_spring.studyspring.repository.MemberRepository;
import com.study_spring.studyspring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }


    /*
     * 회원가입
     * */
    public Long join(Member member){
        //같은 이름이 있는 중복 회원은 안된다. *** 변수자동생성 단축키 : ctrl + alt + v ***
        Optional<Member> result = memberRepository.findByName(member.getName());

        //같은 이름이 있는 지 검사
        result.ifPresent(m ->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });

        //함수로 따로 빼낸다. *** 단축키 -> ctrl + shift + alt + t -> extract method ***
        validationDuplicateMember(member);


        memberRepository.save(member);
        return member.getId();
    }

    private void validationDuplicateMember(Member member) {
        //위에 코드를 더 예쁘게 하기위해서
        memberRepository.findByName(member.getName())
                        .ifPresent(m ->{
                            throw new IllegalStateException("이미 존재하는 회윈입니다.");
                        });
    }

    /*
    * 전체 회원 조회
    * */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
