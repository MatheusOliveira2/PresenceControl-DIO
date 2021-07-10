package com.dio.presenceControl.service;

import com.dio.presenceControl.exception.NotFoundException;
import com.dio.presenceControl.model.Occurrence;
import com.dio.presenceControl.repository.OccurrenceRepository;
import com.dio.presenceControl.repository.OccurrenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OccurrenceService {

    @Autowired
    private OccurrenceRepository occurrenceRepository;

    public OccurrenceService(OccurrenceRepository occurrenceRepository) {
        this.occurrenceRepository = occurrenceRepository;
    }

    public Occurrence save(Occurrence occurrence){
        return this.occurrenceRepository.save(occurrence);
    }

    public List<Occurrence> findAll() {
        return this.occurrenceRepository.findAll();
    }

    public Occurrence getById(long id) {
        return occurrenceRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Occurrence update(Occurrence occurrence){
        Optional<Occurrence> occurrenceFind = this.occurrenceRepository.findById(occurrence.getId());
        if (occurrenceFind.isEmpty()){
            throw new NotFoundException();
        }
        return this.occurrenceRepository.save(occurrence);
    }

    public Occurrence delete(long id) {
        Optional<Occurrence> occurrence = this.occurrenceRepository.findById(id);
        if (occurrence.isEmpty()){
            throw new NotFoundException();
        }
        this.occurrenceRepository.deleteById(occurrence.get().getId());
        return occurrence.get();
    }
}
