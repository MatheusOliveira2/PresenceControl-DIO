package com.dio.presenceControl.repository;

import com.dio.presenceControl.model.CompTime;
import com.dio.presenceControl.model.embeddedID.CompTimeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompTimeRepository extends JpaRepository<CompTime, CompTimeId> {
}
