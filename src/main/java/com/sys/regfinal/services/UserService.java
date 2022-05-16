package com.sys.regfinal.services;

import com.sys.regfinal.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User saveUser(User user );
    User getUserById( Long id );
    User updateUser(User User);

    void deleteUserById(Long id);
}
