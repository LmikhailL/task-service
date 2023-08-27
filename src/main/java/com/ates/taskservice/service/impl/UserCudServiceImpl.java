package com.ates.taskservice.service.impl;

import static org.springframework.util.CollectionUtils.isEmpty;

import com.ates.taskservice.entity.UserCudEntity;
import com.ates.taskservice.repository.UserCudEntityRepository;
import com.ates.taskservice.service.UserCudService;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserCudServiceImpl implements UserCudService {

  private final UserCudEntityRepository userCudEntityRepository;

  @Override
  @Transactional
  public void save(UserCudEntity userCudEntity) {
    log.info("Started saving UserCudEntity: {}", userCudEntity);
    userCudEntityRepository.save(userCudEntity);
  }

  @Override
  @Transactional(readOnly = true)
  public UserCudEntity getRandomUser() {
    log.info("Started getting random user to assign task...");

    List<UserCudEntity> users = userCudEntityRepository.findByRoleNotIn(List.of(
            "ADMIN_POPUG",
            "MANAGER_POPUG"
        )
    );

    if (isEmpty(users)) {
      return null;
    }

    Random random = new Random();
    int randomIndex = random.nextInt(users.size());

    return users.get(randomIndex);
  }
}
