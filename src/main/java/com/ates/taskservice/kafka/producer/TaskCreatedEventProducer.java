package com.ates.taskservice.kafka.producer;

import com.ates.taskservice.model.TaskCreatedEvent;

public interface TaskCreatedEventProducer {

  void produce(TaskCreatedEvent event);
}
