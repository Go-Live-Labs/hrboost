/*package com.gll.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gll.dao.UserDao;
import com.gll.model.User;
import com.gll.model.UserProfile;
import com.gll.security.LoggedInChecker;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	private LoggedInChecker loggedInChecker = null;

	public UserServiceImpl() {
		logger.info("***************************** UserServiceImpl: Initializing.....");
	}

	@Autowired
	UserServiceImpl(LoggedInChecker loggedInChecker) {
		this.loggedInChecker = loggedInChecker;
	}

	@Autowired
	private UserDao userDao;

	@Override
	public void postUser(User user) {
		userDao.postUser(user);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public User getUser(int UserId) {
		return userDao.getUser(UserId);
	}

	@Override
	public void putUser(User user) {
		userDao.putUser(user);

	}

	@Override
	public void patchUser(User user) {
	}

	@Override
	public void deleteUser(String userId) {
		userDao.deleteUser(userId);

	}

	@Override
	public User findById(int id) {
		logger.info("********************** UserServiceImpl.java : findById() ");
		return userDao.findById(id);
	}

	@Override
	public User findByUserName(String userName){
		logger.info("********************************** UserServiceImpl.java : findByUserName() ");
		return userDao.findByUserName(userName);
	}

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		logger.info("************************* CustomUserDetailsService: loadUserByUsername()" + userName);
		User user = findByUserName(userName);
		logger.info("************************* " + "User : " + user);
		if (user == null) {
			logger.info("************************* User not found");
			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));
	}

	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (UserProfile userProfile : user.getUserProfiles()) {
			System.out.println("UserProfile : " + userProfile);
			authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
		}
		System.out.print("authorities :" + authorities);
		return authorities;
	}

	@Override
	public List<String> getPermissions(String username) {
		return new ArrayList<>();
	}

	@Override
	public User getCurrentUser() {
		 return loggedInChecker.getLoggedInUser();
	}

	@Override
	public Boolean isCurrentUserLoggedIn() {
		return loggedInChecker.getLoggedInUser() != null;
	}
}
*/