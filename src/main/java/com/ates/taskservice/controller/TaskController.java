package com.ates.taskservice.controller;


import com.ates.taskservice.facade.TaskFacade;
import com.ates.taskservice.model.rest.CreateTaskRq;
import com.ates.taskservice.model.rest.GetMyTasksRs;
import com.ates.taskservice.model.rest.TaskCreatedRs;
import com.ates.taskservice.model.rest.UpdateTaskRq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks")
public class TaskController {

  private final TaskFacade taskFacade;

  @PostMapping
  public ResponseEntity<TaskCreatedRs> createTask(@RequestBody CreateTaskRq rq) {
    return ResponseEntity.ok(taskFacade.createTask(rq));
  }

  @GetMapping
  public ResponseEntity<GetMyTasksRs> getCurrentUserTasks() {
    return ResponseEntity.ok(taskFacade.getCurrentUserTasks());
  }

  @PatchMapping("{taskId}")
  public ResponseEntity<Void> updateTask(
      @PathVariable(name = "taskId") Long taskId,
      @RequestBody UpdateTaskRq rq
  ) {
    taskFacade.updateTask(taskId, rq);
    return ResponseEntity.noContent().build();
  }
}
