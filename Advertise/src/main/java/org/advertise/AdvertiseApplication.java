package org.advertise;

import java.util.HashSet;
import java.util.Set;

import org.advertise.model.Role;
import org.advertise.model.User;
import org.advertise.model.UserRole;
import org.advertise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdvertiseApplication implements CommandLineRunner{
   @Autowired
   private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(AdvertiseApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
//		try {
//		User user2=new User();
//		user2.setUsername("diksha");
//		user2.setPassword("dik");
//		user2.setEmail("abc@gmail.com");
//		user2.setGender("female");
//		user2.setPhone("921771645");
//		
//		Role role1=new Role();
//		role1.setRoleId(45L);
//		role1.setRolename("ADMIN");
//		Set<UserRole> userRoleSet=new HashSet<>();
//		UserRole userrole=new UserRole();
//		userrole.setRole(role1);
//		userrole.setUser(user2);
//		userRoleSet.add(userrole);
//		
//		User user1=this.userService.createUser(user2, userRoleSet);
//		System.out.print(user1.getUsername());
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
	}

}
