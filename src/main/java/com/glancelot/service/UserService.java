package com.glancelot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glancelot.dao.UserOpsDao;
import com.glancelot.models.User;
import com.glancelot.repositories.UserRepo;

@Service
public class UserService implements UserOpsDao{
     
	@Autowired
	private UserRepo repo;
	
	@Override
	public int save(User user) {
		// TODO Auto-generated method stub
		try {
		repo.save(user);
		return 1;
		}catch(Exception ex)
		{
	          return 0;		
		}
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
try {
		User u = (User)repo.findByEmail(user.getEmail());
		u.setAge(user.getAge());
		u.setName(u.getName());
		u.setEmail(u.getEmail());
		u.setMobile(u.getMobile());
		u.setChatroomstillnow(user.getChatroomstillnow());
	repo.save(u);
	return 1;
}	catch(Exception e) {
		return 0;
}
	}

	@Override
	public int delete(String email) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User view(String email) {

		// TODO Auto-generated method stub
		try {
		User u = (User)repo.findByEmail(email);
		
		return u;
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public User viewByMobile(String phone) {

		// TODO Auto-generated method stub
		try {
		User u = (User)repo.findByMobile(phone);
		
		return u;}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	

	@Override
	public List<User> viewAll() {
		try {
		return repo.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
