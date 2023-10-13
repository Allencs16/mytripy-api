package com.breallencs.mytripyapi.modules.user;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
  
  User editUser(UserDTO userDTO);

  User activateUser(Long userId, boolean isActive);
}
