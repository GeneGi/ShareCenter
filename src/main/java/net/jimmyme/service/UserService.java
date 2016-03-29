package net.jimmyme.service;

import java.util.Map;

import net.jimmyme.model.User;

public interface UserService {
	
	public void addUser(User user);
	public void deleteUser(Integer userId);
	public void updateUser(User user);
	public User getUserById(Integer userId);
	public User getUser(String username,Integer option);
	Map<String, Object> getAllUser(String page, String rows, String sortOrder, String sortIndex);

}
