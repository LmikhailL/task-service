package com.ates.taskservice.facade;

import com.avro.events.streaming.UserSavedEvent;

public interface UserCudFacade {

  void on(UserSavedEvent event);
}
