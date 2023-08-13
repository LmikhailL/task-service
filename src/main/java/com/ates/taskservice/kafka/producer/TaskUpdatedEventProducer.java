package com.ates.taskservice.kafka.producer;

import com.ates.taskservice.model.TaskUpdatedEvent;

public interface TaskUpdatedEventProducer {

  void produce(TaskUpdatedEvent event);
}
