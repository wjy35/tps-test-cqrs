package com.wjy35.nocqrs.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "member_info")
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberInfo {
    @Id
    private Long memberId;

    private String nickname;

    private String name;
}
