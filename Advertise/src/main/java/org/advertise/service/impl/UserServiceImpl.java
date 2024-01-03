package org.advertise.service.impl;

import java.util.Set;

import org.advertise.exception.UserNotFoundException;
import org.advertise.model.User;
import org.advertise.model.UserRole;
import org.advertise.model.repository.RoleRepository;
import org.advertise.model.repository.UserRepository;
import org.advertise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Override
	
	//create user
	public User createUser(User user, Set<UserRole> userRole) throws Exception{
		User user1=this.userRepository.findByUsername(user.getUsername());
		if(user1!=null) {
			System.out.println("user is already there!..");
			throw new Exception("user is already there!..");
		}else {
			for(UserRole ur:userRole) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRole().addAll(userRole);
			user1=userRepository.save(user);
		}
		return user1;
	}
	@Override
	public User getUser(String username) {
		
		return userRepository.findByUsername(username);
	}
	@Override
	public void userDelete(Long userId) {
		userRepository.deleteById(userId);
		
	}
	@Override
	public User getUser(Long user_id) {
		if(userRepository.findById(user_id).isEmpty())
            throw new UserNotFoundException("Requested Cloud Vendor does not exist");
        return userRepository.findById(user_id).get();
	}
	
	
}
