package com.ates.taskservice.facade.impl;

import com.ates.taskservice.entity.TaskEntity;
import com.ates.taskservice.model.rest.TaskCreatedRs;
import org.springframework.stereotype.Component;

@Component
public class TaskCreatedRsMapper {

  public TaskCreatedRs toRs(TaskEntity savedTask) {
    TaskCreatedRs rs = new TaskCreatedRs();
    rs.setTaskId(savedTask.getId());
    return rs;
  }
}
