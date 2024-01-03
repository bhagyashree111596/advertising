package org.advertise.service;

import java.util.Set;

import org.advertise.model.User;
import org.advertise.model.UserRole;

public interface UserService {
  public User createUser(User user,Set<UserRole> userRole) throws Exception;

   public User getUser(String username);
   
   public void userDelete(Long userId);

   public Object getUser(Long user_id);
  
  
}
