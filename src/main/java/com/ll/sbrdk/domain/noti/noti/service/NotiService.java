package com.ll.sbrdk.domain.noti.noti.service;

import com.ll.sbrdk.domain.noti.noti.repository.NotiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotiService {

  private final NotiRepository notiRepository;

}
