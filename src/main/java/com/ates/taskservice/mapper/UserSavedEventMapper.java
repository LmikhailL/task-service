package com.ates.taskservice.mapper;

import com.ates.taskservice.entity.UserCudEntity;
import com.ates.taskservice.model.UserSavedEvent;

public interface UserSavedEventMapper {

  UserCudEntity toUserCudEntity(UserSavedEvent event);
}
