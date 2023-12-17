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
    public void join(MemberInfo memberInfo) {
        memberInfoRepository.save(memberInfo);
    }

    @Override
    @Transactional
    public void updateMemberInfo(MemberInfo memberInfo) {
        memberInfo = memberInfoRepository.findById(memberInfo.getMemberId())
                .orElseThrow(()->new RuntimeException());

        memberInfo.updateNickname(memberInfo.getNickname());
    }

    @Override
    public MemberInfo viewMemberInfo(Long id) {
        MemberInfo memberInfo;
        memberInfo = memberInfoRepository.findById(id)
                .orElseThrow(()->new RuntimeException());

        return memberInfo;
    }
}
