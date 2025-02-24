package com.ll.sbrdk.domain.post.Author.repository;

import com.ll.sbrdk.domain.post.Author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
