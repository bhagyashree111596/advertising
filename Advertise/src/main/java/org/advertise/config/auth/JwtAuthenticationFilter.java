package org.advertise.config.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.advertise.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		 
		  final String requestTokenHeader=request.getHeader("Authorization");
		  System.out.println(requestTokenHeader);
		  String username=null;
		  String jwttoken=null;
		  
		  if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer")) {
			  jwttoken=requestTokenHeader.substring(7);
			  username=jwtUtils.extractUsername(jwttoken);
			  
		  }else {
			  System.out.println("hlelelle");
		  }
		  if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			  UserDetails userDetails=this.userDetailsService.loadUserByUsername(username);
			  if(jwtUtils.validateToken(jwttoken, userDetails)) {
				  UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
	                        userDetails, null, userDetails.getAuthorities());
				  usernamePasswordAuthenticationToken
                  .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				  SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			  }
		  }else {
			  
		  }
		   filterChain.doFilter(request, response);
	}

}
