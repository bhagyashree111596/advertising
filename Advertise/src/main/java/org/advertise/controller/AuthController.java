package org.advertise.controller;



import org.advertise.config.auth.JwtUtils;
import org.advertise.model.LoginRequest;
import org.advertise.model.LoginResponse;
import org.advertise.service.impl.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createToken(@RequestBody LoginRequest loginRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}		
		UserDetails userDetails=this.userDetailsService.loadUserByUsername(loginRequest.getUsername());
		  String token=this.jwtUtils.generateToken(userDetails);

		  System.out.println("Token"+token);
		  System.out.println("controlle 2...........");
		return ResponseEntity.ok(new LoginResponse(token));


	}


	

	  private void authenticate(String username ,String password) throws Exception {

	      try {
	    	   authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

	      }catch(DisabledException e) {
	    	  throw new Exception("user Disabled"+e.getMessage());
	      }catch(BadCredentialsException e) {
	    	  throw new Exception("invaild Credentials ......"+e.getMessage());
	      }
   }
	
	
}
