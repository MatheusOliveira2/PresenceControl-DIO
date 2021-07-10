package com.dio.presenceControl.repository;

import com.dio.presenceControl.model.DataType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataTypeRepository extends JpaRepository<DataType, Long> {
}
