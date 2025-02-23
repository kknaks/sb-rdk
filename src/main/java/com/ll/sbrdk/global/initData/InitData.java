package com.ll.sbrdk.global.initData;


import com.ll.sbrdk.domain.member.member.entity.Member;
import com.ll.sbrdk.domain.member.member.service.MemberService;
import com.ll.sbrdk.domain.post.post.entity.Author;
import com.ll.sbrdk.domain.post.post.entity.Post;
import com.ll.sbrdk.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
  @Bean
  @Order(3)
  public ApplicationRunner initDataNotProd(){
    return new ApplicationRunner() {
      @Transactional
      @Override
      public void run(ApplicationArguments args) throws Exception {
        if (memberService.count()>0) return;
        Member member1 = memberService.join("user1", "1234", "user1").getData();
        Member member2 = memberService.join("user2", "1234", "user2").getData();
        Member member3 = memberService.join("user3", "1234", "user3").getData();

        Author author1 = postService.of(member1);
        Author author2 = postService.of(member2);
        Author author3 = postService.of(member3);

        Post post1 = postService.write(author1, "title1", "content1").getData();
        Post post2 = postService.write(author2, "title2", "content2").getData();
        Post post3 = postService.write(author3, "title3", "content3").getData();

      }
    };
  }
}
