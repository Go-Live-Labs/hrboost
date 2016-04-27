package com.gll.security;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gll.model.User;

public class CustomUserDetails implements UserDetails {
	
	private static final Logger logger = Logger.getLogger(CustomUserDetails.class);
	
	private static final long serialVersionUID = 1L;
	private User user;
    private List<GrantedAuthority> authorities;

    public CustomUserDetails(User user, List<GrantedAuthority> authorities) {
        this.user = user;
        this.authorities = authorities;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String getPassword() {
       // return user.getPassword();
    	return null;
    }

    @Override
    public String getUsername() {
       // return user.getUserName();
    	return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	logger.info("************** : Entering CustomUserDetails--> getAuthorities() " );
    	logger.info("************** : Exiting CustomUserDetails--> getAuthorities() " );
        return authorities;
        
    }
}
