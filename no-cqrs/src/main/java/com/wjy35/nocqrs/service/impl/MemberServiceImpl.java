package com.wjy35.nocqrs.service.impl;

import com.wjy35.nocqrs.db.entity.MemberInfo;
import com.wjy35.nocqrs.db.repository.MemberInfoRepository;
import com.wjy35.nocqrs.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberInfoRepository memberInfoRepository;

    @Override
    @Transactional
    public MemberInfo join(MemberInfo memberInfo) {
        return memberInfoRepository.save(memberInfo);
    }

    @Override
    @Transactional
    public MemberInfo updateMemberInfo(MemberInfo memberInfo) {
        MemberInfo selectedMemberInfo = memberInfoRepository.findById(memberInfo.getMemberId())
                .orElseThrow(()->new RuntimeException());

        selectedMemberInfo.updateNickname(memberInfo.getNickname());
        return memberInfo;
    }

    @Override
    public MemberInfo viewMemberInfo(Long id) {
        MemberInfo memberInfo;
        memberInfo = memberInfoRepository.findById(id)
                .orElseThrow(()->new RuntimeException());

        return memberInfo;
    }
}
