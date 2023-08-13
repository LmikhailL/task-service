package com.ates.taskservice.model.rest;

import lombok.Data;

@Data
public class GetTaskRs {

  private Long id;
  private String status;
  private String description;
}
