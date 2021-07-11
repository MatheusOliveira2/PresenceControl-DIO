package com.dio.presenceControl.controller;

import com.dio.presenceControl.exception.BusinessException;
import com.dio.presenceControl.model.CompTime;
import com.dio.presenceControl.service.CompTimeService;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/compTime")
public class CompTimeController {

    @Autowired
    private CompTimeService compTimeService;

    @PostMapping
    public ResponseEntity<CompTime> createCompTime(@RequestBody @Valid CompTime compTime, Errors errors){
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(this.compTimeService.save(compTime));
    }

    @GetMapping
    public ResponseEntity<List<CompTime>> getCompTimeList(){
        return ResponseEntity.ok(this.compTimeService.findAll());
    }

    @GetMapping("/{compTimeId}/transition/{transitionId}/user/{userId}")
    public ResponseEntity<CompTime> getCompTimeList(@PathVariable("compTimeId") long compTimeId,
                                                        @PathVariable("transitionId") long transitionId, @PathVariable("userId") long userId){
        return ResponseEntity.ok(this.compTimeService.getById(compTimeId, transitionId,userId));
    }

    @PutMapping
    public ResponseEntity<CompTime> updateCompTime(@RequestBody @Valid CompTime compTime, Errors errors){
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(this.compTimeService.update(compTime));
    }

    @DeleteMapping("/{compTimeId}/transition/{transitionId}/user/{userId}")
    public ResponseEntity<CompTime> delete(@PathVariable("compTimeId") long compTimeId,
                                           @PathVariable("transitionId") long transitionId, @PathVariable("userId") long userId){
        return ResponseEntity.ok(this.compTimeService.delete(compTimeId,transitionId,userId));
    }
}
