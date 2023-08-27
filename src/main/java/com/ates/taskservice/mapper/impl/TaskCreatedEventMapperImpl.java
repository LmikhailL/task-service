package com.ates.taskservice.mapper.impl;

import com.ates.taskservice.entity.TaskEntity;
import com.ates.taskservice.mapper.TaskCreatedEventMapper;
import org.springframework.stereotype.Component;
import com.avro.events.streaming.TaskCreatedEvent;
@Component
public class TaskCreatedEventMapperImpl implements TaskCreatedEventMapper {

  @Override
  public
  TaskCreatedEvent toEvent(TaskEntity savedTask) {
    TaskCreatedEvent event = new TaskCreatedEvent();
    event.setId(savedTask.getId());
    event.setUserId(savedTask.getUserCudEntity().getUserKeycloakId());
    event.setTaskStatus(savedTask.getTaskStatus().name());
    event.setAmountOfMoneyToCharge(savedTask.getAmountOfMoneyToCharge());
    event.setJiraId(event.getJiraId());
    event.setTitle(event.getTitle());
    return event;
  }
}
