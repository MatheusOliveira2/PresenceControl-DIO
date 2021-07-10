package com.dio.presenceControl.service;

import com.dio.presenceControl.exception.NotFoundException;
import com.dio.presenceControl.model.Location;
import com.dio.presenceControl.repository.LocationRepository;
import com.dio.presenceControl.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location save(Location location){
        return this.locationRepository.save(location);
    }

    public List<Location> findAll() {
        return this.locationRepository.findAll();
    }

    public Location getById(long id) {
        return locationRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Location update(Location location){
        Optional<Location> locationFind = this.locationRepository.findById(location.getId());
        if (locationFind.isEmpty()){
            throw new NotFoundException();
        }
        return this.locationRepository.save(location);
    }

    public Location delete(long id) {
        Optional<Location> location = this.locationRepository.findById(id);
        if (location.isEmpty()){
            throw new NotFoundException();
        }
        this.locationRepository.deleteById(location.get().getId());
        return location.get();
    }
}
