package com.dio.presenceControl.repository;

import com.dio.presenceControl.model.AccessLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessLevelRepository extends JpaRepository<AccessLevel, Long> {
}
