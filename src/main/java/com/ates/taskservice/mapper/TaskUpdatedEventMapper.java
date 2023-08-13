package com.ates.taskservice.mapper;

import com.ates.taskservice.entity.TaskEntity;
import com.ates.taskservice.model.TaskUpdatedEvent;

public interface TaskUpdatedEventMapper {

  TaskUpdatedEvent toEvent(TaskEntity savedTask);
}
