package com.dio.presenceControl.repository;

import com.dio.presenceControl.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
