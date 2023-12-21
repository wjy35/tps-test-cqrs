package com.wjy35.nocqrs;

import com.wjy35.nocqrs.db.entity.MemberEntity;
import com.wjy35.nocqrs.db.repository.MemberRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    void testRepositoryLoad(){
        assertNotNull(memberRepository);
    }

    @Test
    void testSelectMemberInfo(){
        Long memberId = 1l;

        MemberEntity memberEntity = memberRepository.findById(memberId).get();

        System.out.println("memberInfo.getMemberId() = " + memberEntity.getMemberId());
        assertEquals(memberId, memberEntity.getMemberId());
    }
}
