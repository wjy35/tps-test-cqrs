package com.wjy35.nocqrs.service;

import com.wjy35.nocqrs.db.entity.MemberInfo;

public interface MemberService {
    void join(MemberInfo memberInfo);
    void updateMemberInfo(MemberInfo memberInfo);
    MemberInfo viewMemberInfo(Long id);
}
