package com.ates.taskservice.mapper;

import com.ates.taskservice.entity.TaskEntity;
import com.ates.taskservice.model.rest.CreateTaskRq;

public interface CreateTaskRqMapper {

  TaskEntity toTaskEntity(CreateTaskRq rq);
}
