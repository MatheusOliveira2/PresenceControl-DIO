package com.dio.presenceControl.repository;

import com.dio.presenceControl.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
