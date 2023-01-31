package com.breallencs.mytripyapi.core.jwt;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.breallencs.mytripyapi.core.jwt.resources.JwtTokenRequest;
import com.breallencs.mytripyapi.modules.user.User;
import com.breallencs.mytripyapi.modules.user.UserRepository;

@RestController
public class JwtRestController {
  
  @Value("${jwt.http.request.header}")
	private String tokenHeader;

	@Value("${jwt.signing.key.secret}")
	private String secret;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserDetailsService jwtUserDetailsService;

  @Autowired
  private UserRepository userRepository;

  @RequestMapping(value = "${jwt.get.token.uri}", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtTokenRequest authenticationRequest) throws AuthenticationException {

		final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		
		Optional<User> usuario = userRepository.findByUsername(authenticationRequest.getUsername());

    BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
    
    authenticate(usuario.get().getUsername(), usuario.get().getPassword());
    
	
		return ResponseEntity.ok("");
	}

  private void authenticate(String username, String password) {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);
  
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	}
}
