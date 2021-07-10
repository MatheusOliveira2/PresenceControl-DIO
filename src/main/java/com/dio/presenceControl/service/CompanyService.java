package com.dio.presenceControl.service;

import com.dio.presenceControl.exception.NotFoundException;
import com.dio.presenceControl.model.Company;
import com.dio.presenceControl.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company save(Company company){
        return this.companyRepository.save(company);
    }

    public List<Company> findAll() {
        return this.companyRepository.findAll();
    }

    public Company getById(long id) {
        return companyRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Company update(Company company){
        Optional<Company> companyFind = this.companyRepository.findById(company.getId());
        if (companyFind.isEmpty()){
            throw new NotFoundException();
        }
        return this.companyRepository.save(company);
    }

    public Company delete(long id) {
        Optional<Company> company = this.companyRepository.findById(id);
        if (company.isEmpty()){
            throw new NotFoundException();
        }
        this.companyRepository.deleteById(company.get().getId());
        return company.get();
    }
}
