package com.ates.taskservice.mapper;

import com.ates.taskservice.entity.TaskEntity;
import com.avro.events.streaming.TaskUpdatedEvent;

public interface TaskUpdatedEventMapper {

  TaskUpdatedEvent toEvent(TaskEntity savedTask);
}
