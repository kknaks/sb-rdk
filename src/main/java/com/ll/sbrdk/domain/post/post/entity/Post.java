package com.ll.sbrdk.domain.post.post.entity;

import com.ll.sbrdk.global.jpa.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
public class Post extends BaseEntity {
  private String title;
  private String content;

  @ManyToOne
  private Author author;
}