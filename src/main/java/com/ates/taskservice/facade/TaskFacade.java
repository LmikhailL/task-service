package com.ates.taskservice.facade;

import com.ates.taskservice.model.rest.CreateTaskRq;
import com.ates.taskservice.model.rest.GetMyTasksRs;
import com.ates.taskservice.model.rest.TaskCreatedRs;
import com.ates.taskservice.model.rest.UpdateTaskRq;

public interface TaskFacade {

  TaskCreatedRs createTask(CreateTaskRq rq);

  GetMyTasksRs getCurrentUserTasks();

  void updateTask(Long taskId, UpdateTaskRq rq);
}
