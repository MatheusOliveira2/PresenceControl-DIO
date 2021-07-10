package com.dio.presenceControl.service;


import com.dio.presenceControl.exception.NotFoundException;
import com.dio.presenceControl.model.UserCategory;
import com.dio.presenceControl.model.UserCategory;
import com.dio.presenceControl.repository.UserCategoryRepository;
import com.dio.presenceControl.repository.UserCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCategoryService {

    @Autowired
    private UserCategoryRepository userCategoryRepository;

    public UserCategoryService(UserCategoryRepository userCategoryRepository) {
        this.userCategoryRepository = userCategoryRepository;
    }

    public UserCategory save(UserCategory userCategory){
        return this.userCategoryRepository.save(userCategory);
    }

    public List<UserCategory> findAll() {
        return this.userCategoryRepository.findAll();
    }

    public UserCategory getById(long id) {
        return userCategoryRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public UserCategory update(UserCategory userCategory){
        Optional<UserCategory> userCategoryFind = this.userCategoryRepository.findById(userCategory.getId());
        if (userCategoryFind.isEmpty()){
            throw new NotFoundException();
        }
        return this.userCategoryRepository.save(userCategory);
    }

    public UserCategory delete(long id) {
        Optional<UserCategory> userCategory = this.userCategoryRepository.findById(id);
        if (userCategory.isEmpty()){
            throw new NotFoundException();
        }
        this.userCategoryRepository.deleteById(userCategory.get().getId());
        return userCategory.get();
    }

}
