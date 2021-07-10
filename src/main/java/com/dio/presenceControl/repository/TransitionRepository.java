package com.dio.presenceControl.repository;

import com.dio.presenceControl.model.Transition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransitionRepository extends JpaRepository<Transition, Transition.TransitionId> {
}
