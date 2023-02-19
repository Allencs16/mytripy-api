package com.breallencs.mytripyapi.core.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.breallencs.mytripyapi.core.jwt.JwtTokenUtil;
import com.breallencs.mytripyapi.modules.user.UserRepository;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private UserDetailsService jwtUserDetailsService;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Value("${jwt.http.request.header}")
  private String tokenHeader;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException{
    //todo: corrigir esse If;
    var path = request.getServletPath();
    System.out.println(path);
    if(path == "/authenticate"){
      var token = recuperaToken(request);
      var tokenSubject = jwtTokenUtil.getSubject(token);
    }
    
    chain.doFilter(request, response);
  }
 
  private String recuperaToken(HttpServletRequest request) {
    var authorizationHeader = request.getHeader("Authorization");
    if(authorizationHeader == null){
      throw new RuntimeException("Token is not present");
    }
    return authorizationHeader.replace("Bearer ", "");
  }

}
