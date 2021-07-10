package com.dio.presenceControl.controller;

import com.dio.presenceControl.exception.BusinessException;
import com.dio.presenceControl.model.Occurrence;
import com.dio.presenceControl.service.OccurrenceService;
import com.dio.presenceControl.service.OccurrenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/occurrence")
public class OccurrenceController {

    @Autowired
    private OccurrenceService occurrenceService;

    @PostMapping
    public ResponseEntity<Occurrence> createOccurrence(@RequestBody @Valid Occurrence occurrence, Errors errors){
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(this.occurrenceService.save(occurrence));
    }

    @GetMapping
    public ResponseEntity<List<Occurrence>> getOccurrenceList(){
        return ResponseEntity.ok(this.occurrenceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Occurrence> getOccurrenceList(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(this.occurrenceService.getById(id));
    }

    @PutMapping
    public ResponseEntity<Occurrence> updateOccurrence(@RequestBody @Valid Occurrence occurrence, Errors errors){
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(this.occurrenceService.update(occurrence));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Occurrence> delete(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(this.occurrenceService.delete(id));
    }
}
