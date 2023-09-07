package com.breallencs.mytripyapi.core.jwt;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.breallencs.mytripyapi.core.jwt.resources.JwtTokenRequest;
import com.breallencs.mytripyapi.core.jwt.resources.JwtTokenResponse;
import com.breallencs.mytripyapi.modules.user.User;
import com.breallencs.mytripyapi.modules.user.UserRepository;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
	private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private UserRepository userRepository;

  @RequestMapping(value = "${jwt.get.token.uri}", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtTokenRequest authenticationRequest) throws AuthenticationException {

		final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		var jsonResponse = new JwtTokenResponse();
    
    authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		var token = jwtTokenUtil.gerarToken(userDetails);
		jsonResponse.setToken(token);
    
		return ResponseEntity.ok(jsonResponse);
	}

  private void authenticate(String username, String password) {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);
  
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	}

	

	@RequestMapping(value = "${jwt.refresh.token.uri}", method = RequestMethod.POST)
	public Boolean isTokenExpired(HttpServletRequest request){

		String token = request.getHeader(tokenHeader);

		System.out.println(jwtTokenUtil.getSubject(token));

		return true;
	}
}
