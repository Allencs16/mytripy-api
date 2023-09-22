package com.breallencs.mytripyapi.core.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.breallencs.mytripyapi.core.config.property.MyTripyApiProperty;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter{

    @Autowired
    private MyTripyApiProperty myTripyApiProperty;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		resp.setHeader("Access-Control-Allow-Origin", myTripyApiProperty.getOriginAllowed());
		resp.setHeader("Access-Control-Allow-Credentials", "true");

        if("OPTIONS".equals(req.getMethod()) && myTripyApiProperty.getOriginAllowed().equals(req.getHeader("Origin"))) {
			resp.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
			resp.setHeader("Access-Control-Allow-Headers", "Authorization, Content-type, Accept, pragma, cachecontrol, expires");
			resp.setHeader("Access-Control-Allow-Max-Age", "3600");
			
			resp.setStatus(HttpServletResponse.SC_OK);
		}else {
			chain.doFilter(request, response);
		}
    }

    @Override
	public void init(FilterConfig filterConfig) throws ServletException {		
	}


	@Override
	public void destroy() {		
	}
    
}
