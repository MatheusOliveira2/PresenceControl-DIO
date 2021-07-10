package com.dio.presenceControl.controller;

import com.dio.presenceControl.exception.BusinessException;
import com.dio.presenceControl.model.WorkingDay;
import com.dio.presenceControl.service.WorkingDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/workday")
public class WorkingDayController {

    @Autowired
    private WorkingDayService workingDayService;

    @PostMapping
    public ResponseEntity<WorkingDay> createWorkingDay(@RequestBody @Valid WorkingDay workingDay, Errors errors){
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(this.workingDayService.save(workingDay));
    }

    @GetMapping
    public ResponseEntity<List<WorkingDay>> getWorkingDayList(){
        return ResponseEntity.ok(this.workingDayService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkingDay> getWorkingDayList(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(this.workingDayService.getById(id));
    }

    @PutMapping
    public ResponseEntity<WorkingDay> updateWorkingDay(@RequestBody @Valid WorkingDay workingDay, Errors errors){
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(this.workingDayService.update(workingDay));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WorkingDay> delete(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(this.workingDayService.delete(id));
    }
}
