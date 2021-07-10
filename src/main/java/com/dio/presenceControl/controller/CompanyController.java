package com.dio.presenceControl.controller;

import com.dio.presenceControl.exception.BusinessException;
import com.dio.presenceControl.model.Company;
import com.dio.presenceControl.service.CompanyService;
import com.dio.presenceControl.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody @Valid Company company, Errors errors){
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(this.companyService.save(company));
    }

    @GetMapping
    public ResponseEntity<List<Company>> getCompanyList(){
        return ResponseEntity.ok(this.companyService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyList(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(this.companyService.getById(id));
    }

    @PutMapping
    public ResponseEntity<Company> updateCompany(@RequestBody @Valid Company company, Errors errors){
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(this.companyService.update(company));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Company> delete(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(this.companyService.delete(id));
    }
}
