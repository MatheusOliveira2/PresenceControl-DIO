package com.dio.presenceControl.service;

import com.dio.presenceControl.exception.NotFoundException;
import com.dio.presenceControl.model.AccessLevel;
import com.dio.presenceControl.repository.AccessLevelRepository;
import com.dio.presenceControl.repository.AccessLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccessLevelService {
    @Autowired
    private AccessLevelRepository accessLevelRepository;

    public AccessLevelService(AccessLevelRepository accessLevelRepository) {
        this.accessLevelRepository = accessLevelRepository;
    }

    public AccessLevel save(AccessLevel accessLevel){
        return this.accessLevelRepository.save(accessLevel);
    }

    public List<AccessLevel> findAll() {
        return this.accessLevelRepository.findAll();
    }

    public AccessLevel getById(long id) {
        return accessLevelRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public AccessLevel update(AccessLevel accessLevel){
        Optional<AccessLevel> accessLevelFind = this.accessLevelRepository.findById(accessLevel.getId());
        if (accessLevelFind.isEmpty()){
            throw new NotFoundException();
        }
        return this.accessLevelRepository.save(accessLevel);
    }

    public AccessLevel delete(long id) {
        Optional<AccessLevel> accessLevel = this.accessLevelRepository.findById(id);
        if (accessLevel.isEmpty()){
            throw new NotFoundException();
        }
        this.accessLevelRepository.deleteById(accessLevel.get().getId());
        return accessLevel.get();
    }
}
