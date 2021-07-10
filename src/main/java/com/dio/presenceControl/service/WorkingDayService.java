package com.dio.presenceControl.service;

import com.dio.presenceControl.exception.NotFoundException;
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

    public WorkingDay getById(long id) {
        return workingDayRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public WorkingDay update(WorkingDay workingDay){
        Optional<WorkingDay> workingDayFind = this.workingDayRepository.findById(workingDay.getId());
        if (workingDayFind.isEmpty()){
            throw new NotFoundException();
        }
        return this.workingDayRepository.save(workingDay);
    }

    public WorkingDay delete(long id) {
        Optional<WorkingDay> workingDay = this.workingDayRepository.findById(id);
        if (workingDay.isEmpty()){
            throw new NotFoundException();
        }
        this.workingDayRepository.deleteById(workingDay.get().getId());
        return workingDay.get();
    }


}
