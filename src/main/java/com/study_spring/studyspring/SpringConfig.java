package com.study_spring.studyspring;

import com.study_spring.studyspring.repository.JpaMemberRepository;
import com.study_spring.studyspring.repository.MemberRepository;
import com.study_spring.studyspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(@Qualifier("springDataJpaMemberRepository") MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

/*    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }*/
    /*@Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }*/
}