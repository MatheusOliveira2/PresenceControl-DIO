package com.dio.presenceControl.controller;

import com.dio.presenceControl.model.WorkingDay;
import com.dio.presenceControl.service.WorkingDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/workday")
public class WorkingDayController {

    @Autowired
    private WorkingDayService workingDayService;

    @PostMapping
    public ResponseEntity<WorkingDay> createWorkingDay(@RequestBody WorkingDay workingDay){
        return ResponseEntity.ok(this.workingDayService.save(workingDay));
    }

    @GetMapping
    public ResponseEntity<List<WorkingDay>> getWorkingDayList(){
        return ResponseEntity.ok(this.workingDayService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkingDay> getWorkingDayList(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(this.workingDayService.getById(id).orElseThrow(() -> new NoSuchElementException("workingDay not found.")));
    }

    @PutMapping
    public ResponseEntity<WorkingDay> updateWorkingDay(@RequestBody WorkingDay workingDay){
        return ResponseEntity.ok(this.workingDayService.update(workingDay));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WorkingDay> delete(@PathVariable("id") long id) throws Exception {
        this.workingDayService.delete(id);
        return (ResponseEntity<WorkingDay>) ResponseEntity.ok();
    }
}
