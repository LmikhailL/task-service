package com.ates.taskservice.mapper.impl;

import com.ates.taskservice.entity.TaskEntity;
import com.ates.taskservice.mapper.TaskUpdatedEventMapper;
import com.avro.events.streaming.TaskUpdatedEvent;
import org.springframework.stereotype.Component;

@Component
public class TaskUpdatedEventMapperImpl implements TaskUpdatedEventMapper {

  @Override
  public TaskUpdatedEvent toEvent(TaskEntity savedTask) {
    TaskUpdatedEvent event = new TaskUpdatedEvent();
    event.setId(savedTask.getId());
    event.setUserId(savedTask.getUserCudEntity().getId());
    event.setTaskStatus(savedTask.getTaskStatus().name());
    event.setAmountOfMoneyToPay(savedTask.getAmountOfMoneyToPay());
    return event;
  }
}
