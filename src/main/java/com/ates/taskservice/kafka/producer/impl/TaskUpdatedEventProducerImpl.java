package com.ates.taskservice.kafka.producer.impl;

import static com.ates.taskservice.utils.MdcUtils.getCorrelationId;

import com.ates.taskservice.kafka.producer.ProducerTemplate;
import com.ates.taskservice.kafka.producer.TaskUpdatedEventProducer;
import com.avro.events.streaming.TaskUpdatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskUpdatedEventProducerImpl
    extends ProducerTemplate<TaskUpdatedEvent>
    implements TaskUpdatedEventProducer {

  private final KafkaTemplate<String, TaskUpdatedEvent> template;

  @Value("${spring.kafka.topics.task-updated-topic}")
  private String topic;

  @Override
  public void produce(TaskUpdatedEvent event) {
    log.info("Started producing TaskUpdatedEvent: {}", event);

    template.send(getProducerRecord(event, topic))
        .whenComplete((msg, ex) -> log(event, msg, ex, getCorrelationId()));
  }
}
