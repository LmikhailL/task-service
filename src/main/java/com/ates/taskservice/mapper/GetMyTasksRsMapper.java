package com.ates.taskservice.mapper;

import com.ates.taskservice.entity.TaskEntity;
import com.ates.taskservice.model.rest.GetMyTasksRs;
import java.util.List;

public interface GetMyTasksRsMapper {

  GetMyTasksRs toRs(List<TaskEntity> currentUserTasks);
}
