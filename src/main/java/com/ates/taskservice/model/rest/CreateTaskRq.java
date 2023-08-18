package com.ates.taskservice.model.rest;

import lombok.Data;

@Data
public class CreateTaskRq {

  private String title;
  private Long jiraId;
  private String description;
}
