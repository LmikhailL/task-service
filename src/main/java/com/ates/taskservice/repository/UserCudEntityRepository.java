package com.ates.taskservice.repository;

import com.ates.taskservice.entity.UserCudEntity;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCudEntityRepository extends JpaRepository<UserCudEntity, Long> {

  List<UserCudEntity> findByRoleNotIn(Collection<String> roles);
}