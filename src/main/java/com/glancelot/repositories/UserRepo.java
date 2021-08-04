package com.glancelot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.glancelot.models.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

/*	@Query("select u from User u where u.email=:em")
	public List<User> viewUser(String email);*/
	
	@Query("select u from User u")
	public List<User>  viewAllUsers();
	
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	User findByEmail(String email);
	
	User findByMobile(String mobile);
	
	
}
