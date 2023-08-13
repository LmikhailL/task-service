package com.ates.taskservice.mapper;

import com.ates.taskservice.entity.TaskEntity;
import com.ates.taskservice.model.TaskCreatedEvent;

public interface TaskCreatedEventMapper {

  TaskCreatedEvent toEvent(TaskEntity savedTask);
}
