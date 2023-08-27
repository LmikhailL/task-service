package com.ates.taskservice.model.rest;

import lombok.Data;

@Data
public class CreateTaskRq {

  private String title;
  private String jiraId;
  private String description;
}
