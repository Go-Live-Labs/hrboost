package com.gll.service;

import java.util.List;

import com.gll.model.UserModel;

public interface UserService {
	public void postUser(UserModel UserModel);
	public List<UserModel> getAllUser();
	public UserModel getUser(int UserId);
	public void putUser(UserModel UserModel);
	public void patchUser(UserModel UserModel);
	public void deleteUser(String UserId);
}
