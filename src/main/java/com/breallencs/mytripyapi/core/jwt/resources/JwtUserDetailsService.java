package com.breallencs.mytripyapi.core.jwt.resources;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.breallencs.mytripyapi.modules.user.User;
import com.breallencs.mytripyapi.modules.user.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService{
  
  private UserRepository userRepository;

	public JwtUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		return userRepository.findByUsername(email);
	}
}
