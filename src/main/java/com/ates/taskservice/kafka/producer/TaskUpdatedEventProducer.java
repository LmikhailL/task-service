package com.ates.taskservice.kafka.producer;

import com.avro.events.streaming.TaskUpdatedEvent;

public interface TaskUpdatedEventProducer {

  void produce(TaskUpdatedEvent event);
}
