package com.liftoffproject.premiumdecorsite.service;

import com.liftoffproject.premiumdecorsite.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService  extends UserDetailsService {
    User save(User user);
}


