package com.ll.sbrdk.domain.member.member.service;

import com.ll.sbrdk.domain.member.member.entity.Member;
import com.ll.sbrdk.domain.member.member.repository.MemberRepository;
import com.ll.sbrdk.global.RsData.RsData;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  @Transactional
  public RsData<Member> join(String username, String password, String nickname) {
    return RsData.of(
        memberRepository.save(Member.builder()
            .username(username)
            .password(password)
            .nickname(nickname)
            .build()
        )
    );
  }

  public long count() {
    return memberRepository.count();
  }

  @Transactional
  public void increasePostCount(long id) {
    findById(id).ifPresent(Member::increasePostCount);
  }

  private Optional<Member> findById(long id) {
    return memberRepository.findById(id);
  }
}
