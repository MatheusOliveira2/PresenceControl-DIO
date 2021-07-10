package com.dio.presenceControl.repository;

import com.dio.presenceControl.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
