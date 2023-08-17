package com.ates.taskservice.service.impl;

import com.ates.taskservice.entity.TaskEntity;
import com.ates.taskservice.repository.TaskEntityRepository;
import com.ates.taskservice.service.TaskService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

  private final TaskEntityRepository taskEntityRepository;

  @Override
  @Transactional
  public TaskEntity save(TaskEntity taskEntity) {
    log.info("Started saving TaskEntity: {}", taskEntity);
    return taskEntityRepository.save(taskEntity);
  }

  @Override
  @Transactional(readOnly = true)
  public List<TaskEntity> getTasksByKkId(String kkId) {
    log.info("Started getting current users tasks");
    return taskEntityRepository.findByUserCudEntity_UserKeycloakId(kkId);
  }

  @Override
  @Transactional(readOnly = true)
  public TaskEntity getTaskEntity(Long id) {
    return taskEntityRepository.findById(id).orElse(null);
  }
}
