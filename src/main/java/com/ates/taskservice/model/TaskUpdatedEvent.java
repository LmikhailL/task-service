package com.ates.taskservice.model;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class TaskUpdatedEvent {

  private Long id;
  private TaskStatus taskStatus;
  private BigDecimal amountOfMoneyToPay;
}
