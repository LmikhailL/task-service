package com.ates.taskservice.kafka.producer.impl;

import static com.ates.taskservice.utils.MdcUtils.getCorrelationId;

import com.ates.taskservice.kafka.producer.ProducerTemplate;
import com.ates.taskservice.kafka.producer.TaskCreatedEventProducer;
import com.avro.events.streaming.TaskCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskCreatedEventProducerImpl
    extends ProducerTemplate<TaskCreatedEvent>
    implements TaskCreatedEventProducer {

  private final KafkaTemplate<String, TaskCreatedEvent> template;

  @Value("${spring.kafka.topics.task-created-topic}")
  private String topic;

  @Override
  public void produce(TaskCreatedEvent event) {
    log.info("Started producing TaskCreatedEvent: {}", event);
    template.send(getProducerRecord(event, topic))
        .whenComplete((msg, ex) -> log(event, msg, ex, getCorrelationId()));
  }
}
