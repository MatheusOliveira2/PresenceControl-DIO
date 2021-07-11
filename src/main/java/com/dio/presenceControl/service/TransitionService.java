package com.dio.presenceControl.service;

import com.dio.presenceControl.exception.NotFoundException;
import com.dio.presenceControl.model.Transition;
import com.dio.presenceControl.model.TransitionId;
import com.dio.presenceControl.repository.TransitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransitionService {

    @Autowired
    private TransitionRepository transitionRepository;

    public TransitionService(TransitionRepository transitionRepository) {
        this.transitionRepository = transitionRepository;
    }

    public Transition save(Transition transition){
        return this.transitionRepository.save(transition);
    }

    public List<Transition> findAll() {
        return this.transitionRepository.findAll();
    }

    public Transition getById(long idTransition, long idUser) {
        return transitionRepository.findById(new TransitionId(idTransition,idUser)).orElseThrow(NotFoundException::new);
    }

    public Transition update(Transition transition){
        Optional<Transition> transitionFind = this.transitionRepository.findById(transition.getId());
        if (transitionFind.isEmpty()){
            throw new NotFoundException();
        }
        return this.transitionRepository.save(transition);
    }

    public Transition delete(long idTransition, long idUser) {
        Optional<Transition> transition = this.transitionRepository.findById(new TransitionId(idTransition,idUser));
        if (transition.isEmpty()){
            throw new NotFoundException();
        }
        this.transitionRepository.deleteById(transition.get().getId());
        return transition.get();
    }
}
