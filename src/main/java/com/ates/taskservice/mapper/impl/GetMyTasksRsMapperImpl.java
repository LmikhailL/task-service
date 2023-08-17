package com.ates.taskservice.mapper.impl;

import com.ates.taskservice.entity.TaskEntity;
import com.ates.taskservice.mapper.GetMyTasksRsMapper;
import com.ates.taskservice.model.rest.GetMyTasksRs;
import com.ates.taskservice.model.rest.GetTaskRs;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GetMyTasksRsMapperImpl implements GetMyTasksRsMapper {

  @Override
  public GetMyTasksRs toRs(List<TaskEntity> currentUserTasks) {
    List<GetTaskRs> taskRsList = currentUserTasks.stream().map(this::toGetTaskRs).toList();

    GetMyTasksRs rs = new GetMyTasksRs();
    rs.setTasks(taskRsList);

    return rs;
  }

  private GetTaskRs toGetTaskRs(TaskEntity taskEntity) {
    GetTaskRs rs = new GetTaskRs();
    rs.setDescription(taskEntity.getDescription());
    rs.setId(taskEntity.getId());
    rs.setStatus(taskEntity.getTaskStatus().name());
    return rs;
  }
}
