package com.ates.taskservice.listener;

import com.ates.taskservice.kafka.producer.TaskCreatedEventProducer;
import com.avro.events.streaming.TaskCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class TaskCreatedEventListener {

  private final TaskCreatedEventProducer producer;

  @Async
  @TransactionalEventListener
  public void on(TaskCreatedEvent event) {
    producer.produce(event);
  }
}
