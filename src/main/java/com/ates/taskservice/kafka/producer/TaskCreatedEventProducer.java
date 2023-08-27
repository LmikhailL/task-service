package com.ates.taskservice.kafka.producer;

import com.avro.events.streaming.TaskCreatedEvent;

public interface TaskCreatedEventProducer {

  void produce(TaskCreatedEvent event);
}
