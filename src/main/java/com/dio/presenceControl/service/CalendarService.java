package com.dio.presenceControl.service;

import com.dio.presenceControl.exception.NotFoundException;
import com.dio.presenceControl.model.Calendar;
import com.dio.presenceControl.repository.CalendarRepository;
import com.dio.presenceControl.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarService {
    @Autowired
    private CalendarRepository calendarRepository;

    public CalendarService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    public Calendar save(Calendar calendar){
        return this.calendarRepository.save(calendar);
    }

    public List<Calendar> findAll() {
        return this.calendarRepository.findAll();
    }

    public Calendar getById(long id) {
        return calendarRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Calendar update(Calendar calendar){
        Optional<Calendar> calendarFind = this.calendarRepository.findById(calendar.getId());
        if (calendarFind.isEmpty()){
            throw new NotFoundException();
        }
        return this.calendarRepository.save(calendar);
    }

    public Calendar delete(long id) {
        Optional<Calendar> calendar = this.calendarRepository.findById(id);
        if (calendar.isEmpty()){
            throw new NotFoundException();
        }
        this.calendarRepository.deleteById(calendar.get().getId());
        return calendar.get();
    }
}
