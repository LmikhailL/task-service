package com.ates.taskservice.model.rest;

import java.util.List;
import lombok.Data;

@Data
public class GetMyTasksRs {

  private List<GetTaskRs> tasks;
}
