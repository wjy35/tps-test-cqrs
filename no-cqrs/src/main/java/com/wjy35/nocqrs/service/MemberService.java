package com.wjy35.nocqrs.service;

import com.wjy35.nocqrs.db.entity.MemberInfo;

public interface MemberService {
    MemberInfo join(MemberInfo memberInfo);
    MemberInfo updateMemberInfo(MemberInfo memberInfo);
    MemberInfo viewMemberInfo(Long id);
}
