package com.ll.sbrdk.domain.post.Author.service;


import com.ll.sbrdk.domain.post.Author.entity.Author;
import com.ll.sbrdk.domain.post.Author.repository.AuthorRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {

  private final AuthorRepository authorRepository;

  public Optional<Author> findById(long id) {
    return authorRepository.findById(id);
  }
}
