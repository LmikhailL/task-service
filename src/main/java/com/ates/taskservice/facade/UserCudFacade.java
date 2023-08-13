package com.ates.taskservice.facade;

import com.ates.taskservice.model.UserSavedEvent;

public interface UserCudFacade {

  void on(UserSavedEvent event);
}
