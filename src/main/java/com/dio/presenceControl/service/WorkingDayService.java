package com.dio.presenceControl.service;

import com.dio.presenceControl.model.WorkingDay;
import com.dio.presenceControl.repository.WorkingDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkingDayService {

    @Autowired
    private WorkingDayRepository workingDayRepository;

    public WorkingDayService(WorkingDayRepository workingDayRepository) {
        this.workingDayRepository = workingDayRepository;
    }

    public WorkingDay save(WorkingDay workingDay){
        return this.workingDayRepository.save(workingDay);
    }

    public List<WorkingDay> findAll() {
        return this.workingDayRepository.findAll();
    }

    public Optional<WorkingDay> getById(long id) {
        return this.workingDayRepository.findById(id);
    }

    public WorkingDay update(WorkingDay workingDay){
        return this.workingDayRepository.save(workingDay);
    }

    public void delete(long id) {
        this.workingDayRepository.deleteById(id);
    }


}
