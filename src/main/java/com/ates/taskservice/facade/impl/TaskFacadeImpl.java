package com.ates.taskservice.facade.impl;

import static com.ates.taskservice.utils.UserUuidHolder.getUuid;
import static java.util.Objects.nonNull;

import com.ates.taskservice.entity.TaskEntity;
import com.ates.taskservice.entity.UserCudEntity;
import com.ates.taskservice.facade.TaskFacade;
import com.ates.taskservice.mapper.CreateTaskRqMapper;
import com.ates.taskservice.mapper.GetMyTasksRsMapper;
import com.ates.taskservice.mapper.TaskCreatedEventMapper;
import com.ates.taskservice.mapper.TaskUpdatedEventMapper;
import com.ates.taskservice.mapper.UpdateTaskRqMapper;
import com.ates.taskservice.model.TaskCreatedEvent;
import com.ates.taskservice.model.TaskUpdatedEvent;
import com.ates.taskservice.model.rest.CreateTaskRq;
import com.ates.taskservice.model.rest.GetMyTasksRs;
import com.ates.taskservice.model.rest.TaskCreatedRs;
import com.ates.taskservice.model.rest.UpdateTaskRq;
import com.ates.taskservice.service.TaskService;
import com.ates.taskservice.service.UserCudService;
import com.ates.taskservice.utils.UserUuidHolder;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskFacadeImpl implements TaskFacade {

  private final TaskService taskService;
  private final CreateTaskRqMapper createTaskRqMapper;
  private final UserCudService userCudService;
  private final TaskCreatedRsMapper taskCreatedRsMapper;
  private final GetMyTasksRsMapper getMyTasksRsMapper;
  private final UpdateTaskRqMapper updateTaskRqMapper;
  private final TaskCreatedEventMapper taskCreatedEventMapper;
  private final TaskUpdatedEventMapper taskUpdatedEventMapper;
  private final ApplicationEventPublisher applicationEventPublisher;

  @Override
  @Transactional
  public TaskCreatedRs createTask(CreateTaskRq rq) {
    log.info("Started creating task, rq: {}", rq);

    UserCudEntity randomUser = userCudService.getRandomUser();

    if (nonNull(randomUser)) {
      TaskEntity taskEntity = createTaskRqMapper.toTaskEntity(rq);
      taskEntity.addUser(randomUser);
      TaskEntity savedTask = taskService.save(taskEntity);
      TaskCreatedEvent event =  taskCreatedEventMapper.toEvent(savedTask);
      applicationEventPublisher.publishEvent(event);
      return taskCreatedRsMapper.toRs(savedTask);
    } else {
      throw new RuntimeException("No users with appropriate role found!");
    }
  }

  @Override
  @Transactional(readOnly = true)
  public GetMyTasksRs getCurrentUserTasks() {
    log.info("Started getting current user tasks");

    List<TaskEntity> currentUserTasks = taskService.getTasksByKkId(getUuid());

    return getMyTasksRsMapper.toRs(currentUserTasks);
  }

  @Override
  public void updateTask(Long taskId, UpdateTaskRq rq) {
    log.info("Started updating task with id: {}, rq: {}", taskId, rq);
    TaskEntity taskEntity = taskService.getTaskEntity(taskId);

    if (nonNull(taskEntity)) {
      updateTaskRqMapper.toUpdatedEntity(taskEntity, rq);
      TaskEntity savedTask = taskService.save(taskEntity);
      TaskUpdatedEvent event = taskUpdatedEventMapper.toEvent(savedTask);
      applicationEventPublisher.publishEvent(event);
    }
  }
}
