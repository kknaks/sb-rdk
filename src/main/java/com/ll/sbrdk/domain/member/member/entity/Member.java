package com.ll.sbrdk.domain.member.member.entity;

import static lombok.AccessLevel.PROTECTED;

import com.ll.sbrdk.global.jpa.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
@Getter
@Setter
public class Member extends BaseEntity {
  private String username;
  private String password;
  private String nickname;
}