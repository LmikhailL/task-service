package com.ates.taskservice.listener;

import com.ates.taskservice.kafka.producer.TaskUpdatedEventProducer;
import com.ates.taskservice.model.TaskUpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class TaskUpdatedEventListener {

  private final TaskUpdatedEventProducer producer;

  @Async
  @TransactionalEventListener
  public void on(TaskUpdatedEvent event) {
    producer.produce(event);
  }
}
