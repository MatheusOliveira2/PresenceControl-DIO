package com.dio.presenceControl.service;

import com.dio.presenceControl.exception.NotFoundException;
import com.dio.presenceControl.model.DataType;
import com.dio.presenceControl.repository.DataTypeRepository;
import com.dio.presenceControl.repository.DataTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataTypeService {
    @Autowired
    private DataTypeRepository dataTypeRepository;

    public DataTypeService(DataTypeRepository dataTypeRepository) {
        this.dataTypeRepository = dataTypeRepository;
    }

    public DataType save(DataType dataType){
        return this.dataTypeRepository.save(dataType);
    }

    public List<DataType> findAll() {
        return this.dataTypeRepository.findAll();
    }

    public DataType getById(long id) {
        return dataTypeRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public DataType update(DataType dataType){
        Optional<DataType> dataTypeFind = this.dataTypeRepository.findById(dataType.getId());
        if (dataTypeFind.isEmpty()){
            throw new NotFoundException();
        }
        return this.dataTypeRepository.save(dataType);
    }

    public DataType delete(long id) {
        Optional<DataType> dataType = this.dataTypeRepository.findById(id);
        if (dataType.isEmpty()){
            throw new NotFoundException();
        }
        this.dataTypeRepository.deleteById(dataType.get().getId());
        return dataType.get();
    }
}
