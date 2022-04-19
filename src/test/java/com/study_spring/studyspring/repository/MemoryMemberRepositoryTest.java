package com.study_spring.studyspring.repository;

import com.study_spring.studyspring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.Optional;

// public 으로 굳이 안해도 된다.
class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    //각 테스트 끝날때마다 공용 데이터들을 제거해준다
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("junghyun");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("youngwoo");
        repository.save(member2);

        Member result = repository.findByName("junghyun").get();

        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("junghyun");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("youngwoo");
        repository.save(member2);


        member1.setName("babo");






        List<Member> result = repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
