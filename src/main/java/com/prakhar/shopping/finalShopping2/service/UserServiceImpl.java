package com.prakhar.shopping.finalShopping2.service;

import com.prakhar.shopping.finalShopping2.entity.User;
import com.prakhar.shopping.finalShopping2.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public boolean findByEmail(User user) {

        return userRepo.findByEmail(user.getEmail())== null?false:true;
    }

}
