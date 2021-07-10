package com.dio.presenceControl.controller;

import com.dio.presenceControl.exception.BusinessException;
import com.dio.presenceControl.model.DataType;
import com.dio.presenceControl.service.DataTypeService;
import com.dio.presenceControl.service.DataTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/dataType")
public class DataTypeController {
    @Autowired
    private DataTypeService dataTypeService;

    @PostMapping
    public ResponseEntity<DataType> createDataType(@RequestBody @Valid DataType dataType, Errors errors){
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(this.dataTypeService.save(dataType));
    }

    @GetMapping
    public ResponseEntity<List<DataType>> getDataTypeList(){
        return ResponseEntity.ok(this.dataTypeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataType> getDataTypeList(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(this.dataTypeService.getById(id));
    }

    @PutMapping
    public ResponseEntity<DataType> updateDataType(@RequestBody @Valid DataType dataType, Errors errors){
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(this.dataTypeService.update(dataType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataType> delete(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(this.dataTypeService.delete(id));
    }
}
