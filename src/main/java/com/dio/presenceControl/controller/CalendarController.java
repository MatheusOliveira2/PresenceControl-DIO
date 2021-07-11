package com.dio.presenceControl.controller;


import com.dio.presenceControl.exception.BusinessException;
import com.dio.presenceControl.model.Calendar;
import com.dio.presenceControl.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/calendar")
public class CalendarController {
    @Autowired
    private CalendarService calendarService;

    @PostMapping
    public ResponseEntity<Calendar> createCalendar(@RequestBody @Valid Calendar calendar, Errors errors){
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(this.calendarService.save(calendar));
    }

    @GetMapping
    public ResponseEntity<List<Calendar>> getCalendarList(){
        return ResponseEntity.ok(this.calendarService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calendar> getCalendarList(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(this.calendarService.getById(id));
    }

    @PutMapping
    public ResponseEntity<Calendar> updateCalendar(@RequestBody @Valid Calendar calendar, Errors errors){
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(this.calendarService.update(calendar));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Calendar> delete(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(this.calendarService.delete(id));
    }
}
