package com.ll.sbrdk.domain.post.post.service;

import com.ll.sbrdk.domain.member.member.entity.Member;
import com.ll.sbrdk.domain.post.post.entity.Author;
import com.ll.sbrdk.domain.post.post.entity.Post;
import com.ll.sbrdk.domain.post.post.repository.PostRepository;
import com.ll.sbrdk.global.RsData.RsData;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepository postRepository;

  @PersistenceContext
  private EntityManager entityManager;

  public RsData<Post> write(Author author, String title, String content) {

    author.increasePostsCount();

    return RsData.of(

        postRepository.save(Post.builder()
            .author(author)
            .title(title)
            .content(content)
            .build()
        )
    );
  }

  public Author of(Member member) {
    return entityManager.getReference(Author.class, member.getId());
  }

}
