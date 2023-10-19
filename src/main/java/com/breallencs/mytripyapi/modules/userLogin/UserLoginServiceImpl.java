package com.breallencs.mytripyapi.modules.userLogin;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.breallencs.mytripyapi.modules.user.User;

@Service
public class UserLoginServiceImpl implements UserLoginService{

  private UserLoginRepository userLoginRepository;

  public UserLoginServiceImpl(UserLoginRepository userLoginRepository){
    this.userLoginRepository = userLoginRepository;
  }

  @Override
  public UserLogin createUserLogin(User user) {
    UserLogin userLogin = new UserLogin();
    userLogin.setDateLogin(LocalDateTime.now());
    userLogin.setUser(user);

    userLoginRepository.saveAndFlush(userLogin);

    return userLogin;
  }
  
}
