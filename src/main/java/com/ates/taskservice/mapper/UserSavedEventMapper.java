package com.ates.taskservice.mapper;

import com.ates.taskservice.entity.UserCudEntity;
import com.avro.events.streaming.UserSavedEvent;

public interface UserSavedEventMapper {

  UserCudEntity toUserCudEntity(UserSavedEvent event);
}
