package com.wjy35.nocqrs.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "member_info")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class MemberEntity {
    @Id
    private Long memberId;

    private String nickname;

    private String name;

    public void updateNickname(String nickname){
        this.nickname = nickname;
    }
}
