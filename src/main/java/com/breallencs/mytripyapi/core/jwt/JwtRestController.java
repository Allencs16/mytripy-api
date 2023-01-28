package com.breallencs.mytripyapi.core.jwt;

import java.util.Objects;
import java.util.Optional;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.breallencs.mytripyapi.core.jwt.resources.JwtTokenRequest;
import com.breallencs.mytripyapi.core.jwt.resources.JwtTokenResponse;
import com.breallencs.mytripyapi.core.jwt.resources.JwtTokenUtil;
import com.breallencs.mytripyapi.modules.user.User;
import com.breallencs.mytripyapi.modules.user.UserRepository;

@RestController
public class JwtRestController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private UserDetailsService jwtUserDetailsService;

  @Value("${jwt.signing.key.secret}")
	private String secret;
  
  @RequestMapping(value = "${jwt.get.token.uri}", method = RequestMethod.POST)
  public ResponseEntity<?> criarToken(@RequestBody JwtTokenRequest authenticationRequest) throws AuthenticationException{
    authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

    final UserDetails userDetails = jwtUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

    final String token = jwtTokenUtil.generateToken(userDetails);
    
    return ResponseEntity.ok(new JwtTokenResponse(token, userDetails.getAuthorities()));
  }

  private void authenticate(String username, String password) throws AuthenticationException{
    Objects.requireNonNull(username);
    Objects.requireNonNull(password);

    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    } catch (DisabledException e) {
      throw new AuthenticationException("User_disabled");
    } catch (BadCredentialsException e) {
			throw new AuthenticationException("INVALID_CREDENTIALS");
		}
  }
}
