package com.ates.taskservice.mapper;

import com.ates.taskservice.entity.TaskEntity;
import com.avro.events.streaming.TaskCreatedEvent;

public interface TaskCreatedEventMapper {

  TaskCreatedEvent toEvent(TaskEntity savedTask);
}
