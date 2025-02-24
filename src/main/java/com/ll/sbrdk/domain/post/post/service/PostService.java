package com.ll.sbrdk.domain.post.post.service;

import com.ll.sbrdk.domain.member.member.entity.Member;
import com.ll.sbrdk.domain.post.Author.entity.Author;
import com.ll.sbrdk.domain.post.post.entity.Post;
import com.ll.sbrdk.domain.post.post.repository.PostRepository;
import com.ll.sbrdk.global.RsData.RsData;
import com.ll.sbrdk.global.dto.post.PostDto;
import com.ll.sbrdk.global.event.PostCreatedEvent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepository postRepository;

  @PersistenceContext
  private EntityManager entityManager;

  //스프링 발행자
  private final ApplicationEventPublisher eventPublisher;

  //카파카 발행자
  private final KafkaTemplate<Object, Object> kafkaTemplate;

  public RsData<Post> write(Author author, String title, String content) {

    author.increasePostsCount();

    Post post = postRepository.save(Post.builder()
        .author(author)
        .title(title)
        .content(content)
        .build()
    );

    eventPublisher.publishEvent(new PostCreatedEvent(this, post));

//    kafkaTemplate.send("post-created-1", post.getId()+"번 글이 생성되었습니다.");
    kafkaTemplate.send("post-created-1", new PostDto(post.getTitle(), post.getContent()));

    return RsData.of(post);
  }

  public Author of(Member member) {
    return entityManager.getReference(Author.class, member.getId());
  }

  public Member of(Author author) {
    return entityManager.getReference(Member.class, author.getId());
  }

}
