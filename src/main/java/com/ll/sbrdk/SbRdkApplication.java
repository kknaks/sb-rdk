package com.ll.sbrdk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SbRdkApplication {

  public static void main(String[] args) {
    SpringApplication.run(SbRdkApplication.class, args);
  }

}
