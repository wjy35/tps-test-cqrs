package com.wjy35.nocqrs.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "account")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class AccountEntity {
    @Id
    private Long accountId;

    private String nickname;

    private String name;

    public void updateNickname(String nickname){
        this.nickname = nickname;
    }
}
