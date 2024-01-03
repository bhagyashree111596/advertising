package org.advertise.model.repository;

import org.advertise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long>{
   
	User findByUsername(String uname);

}
