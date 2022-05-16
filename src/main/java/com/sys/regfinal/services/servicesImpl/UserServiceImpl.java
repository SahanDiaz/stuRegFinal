package com.sys.regfinal.services.servicesImpl;

import com.sys.regfinal.entity.User;
import com.sys.regfinal.repository.UserRepository;
import com.sys.regfinal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

//    @Override
//    public User editUser(User user) {
//        return null;
//    }

    @Override
    public User updateUser(User oldUser) {
        return  userRepository.save(oldUser);
    }
}
