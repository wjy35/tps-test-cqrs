package com.wjy35.nocqrs;

import com.wjy35.nocqrs.db.entity.MemberInfo;
import com.wjy35.nocqrs.db.repository.MemberInfoRepository;
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
    private MemberInfoRepository memberInfoRepository;

    @InjectMocks
    private MemberServiceImpl memberService;

    @Test
    void MemberService_view_return_Selected_MemberInfo(){
        //given
        MemberInfo memberInfo = MemberInfo.builder().memberId(1l).nickname("wjy35").name("왕준영").build();
        when(memberInfoRepository.findById(1l)).thenReturn(Optional.ofNullable(memberInfo));

        //when
        MemberInfo selectedMemberInfo = memberService.viewMemberInfo(1l);

        //then
        assertEquals(memberInfo.getMemberId(),selectedMemberInfo.getMemberId());
        System.out.println("selectedMemberInfo = " + selectedMemberInfo.getMemberId());
    }

    @Test
    @Transactional
    void MemberService_join_return_Saved_MemberInfo(){
        //given
        MemberInfo expected = MemberInfo.builder().memberId(1l).nickname("wjy35").name("왕준영").build();
        when(memberInfoRepository.save(any(MemberInfo.class))).thenReturn(expected);

        //when
        MemberInfo actual = memberService.join(expected);

        //then
        assertEquals(expected.getMemberId(),actual.getMemberId());
        verify(memberInfoRepository,times(1)).save(expected);
    }

    @Test
    @Transactional
    void MemberService_update_return_Updated_MemberInfo(){
        //given
        Long memberId = 1l;
        MemberInfo expected = MemberInfo.builder()
                .memberId(memberId)
                .nickname("wjy0516")
                .name("왕준영").build();
        when(memberInfoRepository.findById(memberId)).thenReturn(Optional.ofNullable(expected));

        //when
        MemberInfo actual = memberService.updateMemberInfo(expected);

        //then
        System.out.println("actual.getNickname() = " + actual.getNickname());
        assertEquals(expected.getMemberId(),actual.getMemberId());
    }
}
