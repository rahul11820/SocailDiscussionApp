package com.rahul.user.utils;

import com.rahul.user.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtils {

    public static Long getCurrentUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            // Assuming CustomUserDetails has a method getId() that returns the user ID
            return ((User) principal).getId();
        } else {
            // Handle the case where the principal is not UserDetails or does not contain the user ID
            throw new IllegalStateException("User not authenticated or user ID not available");
        }
    }
}