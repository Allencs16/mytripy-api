package com.breallencs.mytripyapi.modules.userLogin;

import org.springframework.stereotype.Service;

import com.breallencs.mytripyapi.modules.user.User;

@Service
public interface UserLoginService {
  
  UserLogin createUserLogin(User user);
}
