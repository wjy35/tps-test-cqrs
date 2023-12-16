package com.wjy35.nocqrs;

import com.wjy35.nocqrs.db.entity.MemberInfo;
import com.wjy35.nocqrs.db.repository.MemberInfoRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class RepositoryTest {
    @Autowired
    MemberInfoRepository memberInfoRepository;

    @Test
    void testRepositoryLoad(){
        assertNotNull(memberInfoRepository);
    }

    @Test
    void testSelectMemberInfo(){
        Long memberId = 1l;

        MemberInfo memberInfo = memberInfoRepository.findById(memberId).get();

        System.out.println("memberInfo.getMemberId() = " + memberInfo.getMemberId());
        assertEquals(memberId,memberInfo.getMemberId());
    }
}
