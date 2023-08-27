package com.ates.taskservice.mapper.impl;

import static com.ates.taskservice.model.TaskStatus.IN_PROGRESS;

import com.ates.taskservice.entity.TaskEntity;
import com.ates.taskservice.mapper.CreateTaskRqMapper;
import com.ates.taskservice.model.rest.CreateTaskRq;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class CreateTaskRqMapperImpl implements CreateTaskRqMapper {

  @Override
  public TaskEntity toTaskEntity(CreateTaskRq rq) {
    TaskEntity taskEntity = new TaskEntity();
    taskEntity.setTaskStatus(IN_PROGRESS);
    taskEntity.setDescription(rq.getDescription());
    taskEntity.setAmountOfMoneyToCharge(getAmountOfMoneyToCharge());
    taskEntity.setAmountOfMoneyToPay(getAmountOfMoneyToPay());
    taskEntity.setJiraId(rq.getJiraId());
    taskEntity.setTitle(rq.getTitle());
    return taskEntity;
  }

  private static BigDecimal getAmountOfMoneyToCharge() {
    Random random = new Random();
    int scale = 2;
    int min = 1000;
    int max = 2000;
    int randomValue = random.nextInt(max - min + 1) + min;

    return new BigDecimal(BigInteger.valueOf(randomValue), scale).movePointLeft(scale);
  }

  private static BigDecimal getAmountOfMoneyToPay() {
    Random random = new Random();
    int scale = 2;
    int min = 2000;
    int max = 4000;
    int randomValue = random.nextInt(max - min + 1) + min;

    return new BigDecimal(BigInteger.valueOf(randomValue), scale).movePointLeft(scale);
  }
}
