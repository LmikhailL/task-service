package com.ates.taskservice.service;

import com.ates.taskservice.entity.TaskEntity;
import java.util.List;

public interface TaskService {

  TaskEntity save(TaskEntity taskEntity);

  List<TaskEntity> getTasksByKkId(String kkId);

  TaskEntity getTaskEntity(Long id);
}
