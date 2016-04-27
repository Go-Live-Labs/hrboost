package com.gll.security;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.gll.model.User;

@Component
public class LoggedInChecker {
	
	private static final Logger logger = Logger.getLogger(LoggedInChecker.class); 
	
    public User getLoggedInUser() {
        
    	logger.info("************** : Entering LoggedInChecker--> getLoggedInUser() " );
    	
    	User user = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof CustomUserDetails) {
                CustomUserDetails userDetails = (CustomUserDetails) principal;
                user = userDetails.getUser();
            }
        }
        logger.info("************** : Exitiing LoggedInChecker--> getLoggedInUser() " + user.toString());
        return user;
    }
}
