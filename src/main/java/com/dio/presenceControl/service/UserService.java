package com.dio.presenceControl.service;

import com.dio.presenceControl.exception.NotFoundException;
import com.dio.presenceControl.model.User;
import com.dio.presenceControl.repository.UserRepository;
import com.dio.presenceControl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user){
        return this.userRepository.save(user);
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User getById(long id) {
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public User update(User user){
        Optional<User> userFind = this.userRepository.findById(user.getId());
        if (userFind.isEmpty()){
            throw new NotFoundException();
        }
        return this.userRepository.save(user);
    }

    public User delete(long id) {
        Optional<User> user = this.userRepository.findById(id);
        if (user.isEmpty()){
            throw new NotFoundException();
        }
        this.userRepository.deleteById(user.get().getId());
        return user.get();
    }
}
