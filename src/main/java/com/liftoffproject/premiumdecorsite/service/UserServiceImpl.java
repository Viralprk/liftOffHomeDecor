package com.liftoffproject.premiumdecorsite.service;

import com.liftoffproject.premiumdecorsite.model.User;
import com.liftoffproject.premiumdecorsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User resiterUser) {
        User user = new User(resiterUser.getFirstName(), resiterUser.getLastName(),
                resiterUser.getEmail(), resiterUser.getPassword(),resiterUser.getRoles());
        return userRepository.save(user);
    }
}