package com.ll.sbrdk.domain.post.Author.entity;

import static lombok.AccessLevel.PRIVATE;

import com.ll.sbrdk.global.jpa.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name="member")
public class Author extends BaseEntity {
  @Column(name="nickname")
  private String writer;

  @Column(columnDefinition = "BIGINT default 0")
  @Setter(PRIVATE)
  private long postsCount;

  public void increasePostsCount() {
    postsCount++;
  }
}
