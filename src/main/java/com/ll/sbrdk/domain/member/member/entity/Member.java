package com.ll.sbrdk.domain.member.member.entity;

import com.ll.sbrdk.global.jap.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Member extends BaseEntity {
  private String username;
  private String password;
  private String nickname;
}