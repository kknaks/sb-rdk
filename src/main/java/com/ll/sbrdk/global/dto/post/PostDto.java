package com.ll.sbrdk.global.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDto {
  private String title;
  private String content;

  @Override
  public String toString() {
    return "PostDto{" +
            "title='" + title + '\'' +
            ", content='" + content + '\'' +
            '}';
  }
}
