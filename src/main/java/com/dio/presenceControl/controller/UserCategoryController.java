package com.dio.presenceControl.controller;


import com.dio.presenceControl.exception.BusinessException;
import com.dio.presenceControl.model.UserCategory;
import com.dio.presenceControl.service.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/userCategory")
public class UserCategoryController {

    @Autowired
    private UserCategoryService userCategoryService;

    @PostMapping
    public ResponseEntity<UserCategory> createUserCategory(@RequestBody @Valid UserCategory userCategory, Errors errors){
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(this.userCategoryService.save(userCategory));
    }

    @GetMapping
    public ResponseEntity<List<UserCategory>> getUserCategoryList(){
        return ResponseEntity.ok(this.userCategoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserCategory> getUserCategoryList(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(this.userCategoryService.getById(id));
    }

    @PutMapping
    public ResponseEntity<UserCategory> updateUserCategory(@RequestBody @Valid UserCategory userCategory, Errors errors){
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(this.userCategoryService.update(userCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserCategory> delete(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(this.userCategoryService.delete(id));
    }
}
