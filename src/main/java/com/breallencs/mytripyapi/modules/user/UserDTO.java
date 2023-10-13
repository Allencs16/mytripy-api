package com.breallencs.mytripyapi.modules.user;

import java.time.LocalDateTime;

import com.breallencs.mytripyapi.enums.UserType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

  private Long id;
  private String name;
  private String username;
  private String email;
  private String password;
  private UserType userType;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
