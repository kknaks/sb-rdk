package com.ll.sbrdk.domain.member.member.repository;

import com.ll.sbrdk.domain.member.member.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
  Optional<Member> findByUsername(String username);
  Optional<Member> findByNickname(String nickname);

}
