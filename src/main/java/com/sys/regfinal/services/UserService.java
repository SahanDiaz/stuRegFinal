package com.sys.regfinal.services;

import com.sys.regfinal.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    List<User> getAllUsers();

    User saveUser(User user);

    User getUserById(Long idd);

//    User editUser(User user);

    User updateUser(User oldUser);
}
