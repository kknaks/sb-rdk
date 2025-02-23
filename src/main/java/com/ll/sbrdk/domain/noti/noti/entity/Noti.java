package com.ll.sbrdk.domain.noti.noti.entity;

import static lombok.AccessLevel.PROTECTED;

import com.ll.sbrdk.domain.member.member.entity.Member;
import com.ll.sbrdk.global.jpa.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
public class Noti extends BaseEntity {
  @ManyToOne
  private Member actor;
  @ManyToOne
  private Member receiver;
  private String relTypeCode;
  private long relId;
  private String typeCode;
  private String type2Code;
  private boolean read;

}
