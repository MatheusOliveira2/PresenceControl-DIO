package com.dio.presenceControl.controller;

import com.dio.presenceControl.exception.BusinessException;
import com.dio.presenceControl.model.Transition;
import com.dio.presenceControl.service.TransitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transition")
public class TransitionController {

    @Autowired
    private TransitionService transitionService;

    @PostMapping
    public ResponseEntity<Transition> createTransition(@RequestBody @Valid Transition transition, Errors errors){
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(this.transitionService.save(transition));
    }

    @GetMapping
    public ResponseEntity<List<Transition>> getTransitionList(){
        return ResponseEntity.ok(this.transitionService.findAll());
    }

    @GetMapping("/{transitionId}/user/{userId}")
    public ResponseEntity<Transition> getTransitionList(@PathVariable("transitionId") long transitionId, @PathVariable("userId") long userId){
        return ResponseEntity.ok(this.transitionService.getById(transitionId, userId));
    }

    @PutMapping
    public ResponseEntity<Transition> updateTransition(@RequestBody @Valid Transition transition, Errors errors){
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(this.transitionService.update(transition));
    }

    @DeleteMapping("/{transitionId}/user/{userId}")
    public ResponseEntity<Transition> delete(@PathVariable("transitionId") long transitionId, @PathVariable("userId") long userId){
        return ResponseEntity.ok(this.transitionService.delete(transitionId,userId));
    }
}
