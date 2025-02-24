package com.ll.sbrdk.global.initData;


import com.ll.sbrdk.domain.member.member.entity.Member;
import com.ll.sbrdk.domain.member.member.service.MemberService;
import com.ll.sbrdk.domain.post.Author.entity.Author;
import com.ll.sbrdk.domain.post.Author.service.AuthorService;
import com.ll.sbrdk.domain.post.post.entity.Post;
import com.ll.sbrdk.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

@Profile("!prod")
@Configuration
@RequiredArgsConstructor
@Slf4j
public class InitData {

  private final MemberService memberService;
  private final PostService postService;
  private final AuthorService authorService;

  @Autowired
  @Lazy
  private InitData self;

  @Bean
  @Order(3)
  public ApplicationRunner initDataNotProd(){
    return args -> {
      if (memberService.count()>0) return;
      self.work1();
      self.work2();
      self.work3();
    };
  }

  @Transactional
  public void work1() {
    Member member1 = memberService.join("user1", "1234", "user1").getData();
    Member member2 = memberService.join("user2", "1234", "user2").getData();
    Member member3 = memberService.join("user3", "1234", "user3").getData();
  }

  @Transactional
  public void work2() {
    Author author1 = authorService.findById(1L).get();
    Author author2 = authorService.findById(2L).get();

    Post post1 = postService.write(author1, "title1", "content1").getData();
    Post post2 = postService.write(author2, "title2", "content2").getData();

  }

  @Transactional
  public void work3() {
    Author author3 = authorService.findById(3L).get();

    Post post3 = postService.write(author3, "title3", "content3").getData();
  }

}

