package com.ates.taskservice.model.rest;

import com.ates.taskservice.model.TaskStatus;
import lombok.Data;

@Data
public class UpdateTaskRq {

  private TaskStatus taskStatus;
}
