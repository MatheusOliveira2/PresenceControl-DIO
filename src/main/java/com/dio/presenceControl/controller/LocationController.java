package com.dio.presenceControl.controller;

import com.dio.presenceControl.exception.BusinessException;
import com.dio.presenceControl.model.Location;
import com.dio.presenceControl.service.LocationService;
import com.dio.presenceControl.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody @Valid Location location, Errors errors){
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(this.locationService.save(location));
    }

    @GetMapping
    public ResponseEntity<List<Location>> getLocationList(){
        return ResponseEntity.ok(this.locationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationList(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(this.locationService.getById(id));
    }

    @PutMapping
    public ResponseEntity<Location> updateLocation(@RequestBody @Valid Location location, Errors errors){
        if(errors.hasErrors()){
            throw new BusinessException(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.ok(this.locationService.update(location));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Location> delete(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.ok(this.locationService.delete(id));
    }
}
