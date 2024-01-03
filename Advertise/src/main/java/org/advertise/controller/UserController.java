package org.advertise.controller;

import java.util.HashSet;
import java.util.Set;

import org.advertise.model.Role;
import org.advertise.model.User;
import org.advertise.model.UserRole;
import org.advertise.response.ResponseHandler;
import org.advertise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
  private UserService userService;
	
	@PostMapping("/")
	public User createuser(@RequestBody User user ) throws Exception {
//		User u=new User();
//		u.setUsername(user.getUsername());
//		u.setPassword(user.getPassword());
//		u.setEmail(user.getEmail());
//		u.setGender(user.getGender());
//		u.setPhone(user.getPhone());
		Set<UserRole> roles=new HashSet<>();
		
		Role r=new Role();
		r.setRoleId(45L);
		r.setRolename("Normal");
		
		UserRole rs=new UserRole();
		rs.setUser(user);
		rs.setRole(r);
		
		roles.add(rs);
		return this.userService.createUser(user,roles);
		
	}
//	@GetMapping("/{user1/user_id}")
//	public ResponseEntity<Object> getUserDetails(@PathVariable("user_id") Long user_id)
//    {
//       return ResponseHandler.responseBuilder("Requested User Details are given here",
//                HttpStatus.OK, userService.getUser(user_id));
//    }
	@GetMapping("/{username}")
	public ResponseEntity<Object> getUserById(@PathVariable(value ="username") String username) {
		 return ResponseHandler.responseBuilder("Requested User Details are given here",
	                HttpStatus.OK, userService.getUser(username));
	  
//		return userService.getUser(username);
		
	}
	
	//update 
	
	@DeleteMapping("/{userId}")
	public void userDelete(@PathVariable(value="userId") Long UserId) {
		userService.userDelete(UserId);
	}
	
}
