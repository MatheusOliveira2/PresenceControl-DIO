package com.dio.presenceControl.controller;

import com.dio.presenceControl.exception.BusinessException;
import com.dio.presenceControl.model.AccessLevel;
import com.dio.presenceControl.service.AccessLevelService;
import com.dio.presenceControl.service.AccessLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/accessLevel")
public class AccessLevelController {
    @Autowired
    private AccessLevelService accessLevelService;

    @PostMapping
    public ResponseEntity<AccessLevel> createAccessLevel(@RequestBody @Valid AccessLevel accessLevel, Errors errors){
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(this.accessLevelService.save(accessLevel));
    }

    @GetMapping
    public ResponseEntity<List<AccessLevel>> getAccessLevelList(){
        return ResponseEntity.ok(this.accessLevelService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccessLevel> getAccessLevelList(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(this.accessLevelService.getById(id));
    }

    @PutMapping
    public ResponseEntity<AccessLevel> updateAccessLevel(@RequestBody @Valid AccessLevel accessLevel, Errors errors){
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(this.accessLevelService.update(accessLevel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AccessLevel> delete(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(this.accessLevelService.delete(id));
    }

}
