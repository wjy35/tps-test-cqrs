package com.wjy35.nocqrs.service.impl;

import com.wjy35.nocqrs.db.entity.MemberEntity;
import com.wjy35.nocqrs.db.repository.MemberRepository;
import com.wjy35.nocqrs.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public MemberEntity join(MemberEntity memberEntity) {
        return memberRepository.save(memberEntity);
    }

    @Override
    @Transactional
    public MemberEntity updateMemberInfo(MemberEntity memberEntity) {
        MemberEntity selectedMemberEntity = memberRepository.findById(memberEntity.getMemberId())
                .orElseThrow(()->new RuntimeException());

        selectedMemberEntity.updateNickname(memberEntity.getNickname());
        return memberEntity;
    }

    @Override
    public MemberEntity viewMemberInfo(Long id) {
        MemberEntity memberEntity;
        memberEntity = memberRepository.findById(id)
                .orElseThrow(()->new RuntimeException());

        return memberEntity;
    }
}
