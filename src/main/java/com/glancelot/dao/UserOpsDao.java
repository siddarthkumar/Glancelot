package com.glancelot.dao;

import com.glancelot.models.User;
import java.util.List;

public interface UserOpsDao {
	
	public int save(User user);
	
	public int update(User user);
	
	public int delete(String email);
	
	public  User view(String email);
	
	public  User viewByMobile(String email);
	
	public  List<User> viewAll();
	

}
