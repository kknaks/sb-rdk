package com.ll.sbrdk.domain.noti.noti.eventListener;

import com.ll.sbrdk.domain.noti.noti.service.NotiService;
import com.ll.sbrdk.global.dto.post.PostDto;
import com.ll.sbrdk.global.event.PostCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class NotiEventListener {
  private final NotiService notiService;

  @EventListener
  @Async
  public void listenPost(PostCreatedEvent event){
    notiService.postCreated(event.getPost());
  }

//  @KafkaListener(topics = "post-created-1", groupId = "2")
//  public void consume2(String message){
//    System.out.println("Consumed message: " + message);
//  }

  @KafkaListener(topics = "post-created-1", groupId = "2")
  public void consume2(PostDto postDto){
    System.out.println("Consumed message: " + postDto.toString());
  }
}
