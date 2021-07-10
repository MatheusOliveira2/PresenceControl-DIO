package com.dio.presenceControl.repository;

import com.dio.presenceControl.model.Occurrence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccurrenceRepository extends JpaRepository<Occurrence, Long> {
}
