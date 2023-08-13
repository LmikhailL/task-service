package com.ates.taskservice.service;

import com.ates.taskservice.entity.UserCudEntity;

public interface UserCudService {

  void save(UserCudEntity userCudEntity);

  UserCudEntity getRandomUser();
}
