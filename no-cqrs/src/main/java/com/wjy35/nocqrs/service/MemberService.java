package com.wjy35.nocqrs.service;

import com.wjy35.nocqrs.db.entity.MemberEntity;

public interface MemberService {
    MemberEntity join(MemberEntity memberEntity);
    MemberEntity updateMemberInfo(MemberEntity memberEntity);
    MemberEntity viewMemberInfo(Long id);
}
