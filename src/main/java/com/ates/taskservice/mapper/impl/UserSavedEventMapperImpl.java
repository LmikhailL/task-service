package com.ates.taskservice.mapper.impl;

import com.ates.taskservice.entity.UserCudEntity;
import com.ates.taskservice.mapper.UserSavedEventMapper;
import com.ates.taskservice.model.UserSavedEvent;
import org.springframework.stereotype.Component;

@Component
public class UserSavedEventMapperImpl implements UserSavedEventMapper {

  @Override
  public UserCudEntity toUserCudEntity(UserSavedEvent event) {
    UserCudEntity userCudEntity = new UserCudEntity();
    userCudEntity.setUserKeycloakId(event.getUserKeycloakId());
    userCudEntity.setFirstName(event.getFirstName());
    userCudEntity.setLastName(event.getLastName());
    userCudEntity.setRole(event.getRole());
    return userCudEntity;
  }
}
