package com.ates.taskservice.mapper;

import com.ates.taskservice.entity.TaskEntity;
import com.ates.taskservice.model.rest.UpdateTaskRq;

public interface UpdateTaskRqMapper {

  void toUpdatedEntity(TaskEntity taskEntity, UpdateTaskRq rq);
}
