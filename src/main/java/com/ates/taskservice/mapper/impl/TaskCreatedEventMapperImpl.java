package com.ates.taskservice.mapper.impl;

import com.ates.taskservice.entity.TaskEntity;
import com.ates.taskservice.mapper.TaskCreatedEventMapper;
import com.ates.taskservice.model.TaskCreatedEvent;
import org.springframework.stereotype.Component;

@Component
public class TaskCreatedEventMapperImpl implements TaskCreatedEventMapper {

  @Override
  public TaskCreatedEvent toEvent(TaskEntity savedTask) {
    TaskCreatedEvent event = new TaskCreatedEvent();
    event.setId(savedTask.getId());
    event.setTaskStatus(savedTask.getTaskStatus().name());
    event.setAmountOfMoneyToCharge(savedTask.getAmountOfMoneyToCharge());
    return event;
  }
}
