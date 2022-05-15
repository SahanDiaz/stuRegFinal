package com.sys.regfinal.repository;

import com.sys.regfinal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
