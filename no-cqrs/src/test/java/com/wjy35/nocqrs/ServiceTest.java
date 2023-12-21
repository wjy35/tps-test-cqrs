package com.wjy35.nocqrs;

import com.wjy35.nocqrs.db.entity.MemberEntity;
import com.wjy35.nocqrs.db.repository.MemberRepository;
import com.wjy35.nocqrs.service.impl.MemberServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberServiceImpl memberService;

    @Test
    void MemberService_view_return_Selected_MemberInfo(){
        //given
        MemberEntity memberEntity = MemberEntity.builder().memberId(1l).nickname("wjy35").name("왕준영").build();
        when(memberRepository.findById(1l)).thenReturn(Optional.ofNullable(memberEntity));

        //when
        MemberEntity selectedMemberEntity = memberService.viewMemberInfo(1l);

        //then
        assertEquals(memberEntity.getMemberId(), selectedMemberEntity.getMemberId());
        System.out.println("selectedMemberInfo = " + selectedMemberEntity.getMemberId());
    }

    @Test
    @Transactional
    void MemberService_join_return_Saved_MemberInfo(){
        //given
        MemberEntity expected = MemberEntity.builder().memberId(1l).nickname("wjy35").name("왕준영").build();
        when(memberRepository.save(any(MemberEntity.class))).thenReturn(expected);

        //when
        MemberEntity actual = memberService.join(expected);

        //then
        assertEquals(expected.getMemberId(),actual.getMemberId());
        verify(memberRepository,times(1)).save(expected);
    }

    @Test
    @Transactional
    void MemberService_update_return_Updated_MemberInfo(){
        //given
        Long memberId = 1l;
        MemberEntity expected = MemberEntity.builder()
                .memberId(memberId)
                .nickname("wjy0516")
                .name("왕준영").build();
        when(memberRepository.findById(memberId)).thenReturn(Optional.ofNullable(expected));

        //when
        MemberEntity actual = memberService.updateMemberInfo(expected);

        //then
        System.out.println("actual.getNickname() = " + actual.getNickname());
        assertEquals(expected.getMemberId(),actual.getMemberId());
    }
}
