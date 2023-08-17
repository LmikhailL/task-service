package com.ates.taskservice.repository;

import com.ates.taskservice.entity.TaskEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskEntityRepository extends JpaRepository<TaskEntity, Long> {

  @Query("select t from TaskEntity t where t.userCudEntity.userKeycloakId = ?1")
  List<TaskEntity> findByUserCudEntity_UserKeycloakId(String userKeycloakId);
}