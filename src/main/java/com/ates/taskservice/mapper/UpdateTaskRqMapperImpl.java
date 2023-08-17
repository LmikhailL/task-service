package com.ates.taskservice.mapper;

import com.ates.taskservice.entity.TaskEntity;
import com.ates.taskservice.model.rest.UpdateTaskRq;
import org.springframework.stereotype.Component;

@Component
public class UpdateTaskRqMapperImpl implements UpdateTaskRqMapper {

  @Override
  public void toUpdatedEntity(TaskEntity taskEntity, UpdateTaskRq rq) {
    taskEntity.setTaskStatus(rq.getTaskStatus());
  }
}
