package com.ates.taskservice.facade.impl;

import com.ates.taskservice.entity.UserCudEntity;
import com.ates.taskservice.facade.UserCudFacade;
import com.ates.taskservice.mapper.UserSavedEventMapper;
import com.ates.taskservice.model.UserSavedEvent;
import com.ates.taskservice.service.UserCudService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserCudFacadeImpl implements UserCudFacade {

  private final UserCudService userCudService;
  private final UserSavedEventMapper userSavedEventMapper;

  @Override
  public void on(UserSavedEvent event) {
    UserCudEntity userCudEntity = userSavedEventMapper.toUserCudEntity(event);
    //todo: enhance with distributed transactions(not now)
    userCudService.save(userCudEntity);
  }
}
