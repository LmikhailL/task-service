package com.ates.taskservice.model;

import lombok.Data;

@Data
public class UserSavedEvent {

  private String userKeycloakId;
  private String firstName;
  private String lastName;
  private String role;
}
