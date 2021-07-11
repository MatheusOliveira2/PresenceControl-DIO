package com.dio.presenceControl.service;

import com.dio.presenceControl.exception.NotFoundException;
import com.dio.presenceControl.model.CompTime;
import com.dio.presenceControl.model.embeddedID.CompTimeId;
import com.dio.presenceControl.repository.CompTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompTimeService {

    @Autowired
    private CompTimeRepository compTimeRepository;

    public CompTimeService(CompTimeRepository compTimeRepository) {
        this.compTimeRepository = compTimeRepository;
    }

    public CompTime save(CompTime compTime){
        return this.compTimeRepository.save(compTime);
    }

    public List<CompTime> findAll() {
        return this.compTimeRepository.findAll();
    }

    public CompTime getById(long idCompTime, long idTransition, long idUser) {
        return compTimeRepository.findById(new CompTimeId(idCompTime,idTransition,idUser)).orElseThrow(NotFoundException::new);
    }

    public CompTime update(CompTime compTime){
        Optional<CompTime> compTimeFind = this.compTimeRepository.findById(compTime.getId());
        if (compTimeFind.isEmpty()){
            throw new NotFoundException();
        }
        return this.compTimeRepository.save(compTime);
    }

    public CompTime delete(long idCompTime, long idTransition, long idUser) {
        Optional<CompTime> compTime = this.compTimeRepository.findById(new CompTimeId(idCompTime,idTransition,idUser));
        if (compTime.isEmpty()){
            throw new NotFoundException();
        }
        this.compTimeRepository.deleteById(compTime.get().getId());
        return compTime.get();
    }
}
