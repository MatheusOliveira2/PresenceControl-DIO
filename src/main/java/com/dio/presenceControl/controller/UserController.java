package com.dio.presenceControl.controller;


import com.dio.presenceControl.exception.BusinessException;
import com.dio.presenceControl.model.User;
import com.dio.presenceControl.service.UserService;
import com.dio.presenceControl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(this.userService.save(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getUserList(){
        return ResponseEntity.ok(this.userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserList(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(this.userService.getById(id));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(this.userService.update(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(this.userService.delete(id));
    }
}
