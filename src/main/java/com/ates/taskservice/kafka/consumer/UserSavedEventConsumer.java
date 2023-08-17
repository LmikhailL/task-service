package com.ates.taskservice.kafka.consumer;

import static com.ates.taskservice.utils.JsonMappingUtils.mapTo;
import static com.ates.taskservice.utils.MdcUtils.CORRELATION_ID;
import static com.ates.taskservice.utils.MdcUtils.setCorrelationId;

import com.ates.taskservice.facade.TaskFacade;
import com.ates.taskservice.facade.UserCudFacade;
import com.ates.taskservice.model.UserSavedEvent;
import com.ates.taskservice.utils.JsonMappingUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserSavedEventConsumer {

  private final UserCudFacade userCudFacade;

  @KafkaListener(
      topics = "${spring.kafka.topics.user-saved-topic}",
      groupId = "${spring.kafka.consumer.group-id}"
  )
  public void consume(
      @Payload String message,
      @Header(CORRELATION_ID) String customHeader
  ) {
    setCorrelationId(customHeader);
    log.info("Received UserSavedEvent: {}", message);

    UserSavedEvent event = mapTo(message, UserSavedEvent.class);
    userCudFacade.on(event);
  }
}
