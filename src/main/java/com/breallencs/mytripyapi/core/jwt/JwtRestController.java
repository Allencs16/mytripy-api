package com.breallencs.mytripyapi.core.jwt;

import java.util.Objects;

import javax.naming.AuthenticationException;
import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.breallencs.mytripyapi.core.jwt.resources.JwtTokenRequest;
import com.breallencs.mytripyapi.core.jwt.resources.JwtTokenResponse;
import com.breallencs.mytripyapi.core.jwt.resources.JwtTokenUtil;

@RestController
public class JwtRestController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Value("${jwt.signing.key.secret}")
  private String secret;
  
  @PostMapping("${jwt.get.token.uri}")
  public ResponseEntity efetuarLogin(@RequestBody JwtTokenRequest dados) throws AuthenticationException  {
    var authenticationToken = new UsernamePasswordAuthenticationToken(dados.getUsername(), dados.getPassword());
    var authentication = authenticationManager.authenticate(authenticationToken);
    return ResponseEntity.ok(authentication.isAuthenticated());
  }
}
