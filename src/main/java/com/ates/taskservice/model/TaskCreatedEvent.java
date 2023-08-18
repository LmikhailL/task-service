package com.ates.taskservice.model;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class TaskCreatedEvent {

  private Long id;
  private String taskStatus;
  private BigDecimal amountOfMoneyToCharge;
  private String title;
  private Long jiraId;
}
