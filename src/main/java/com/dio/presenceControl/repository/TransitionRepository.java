package com.dio.presenceControl.repository;

import com.dio.presenceControl.model.Transition;
import com.dio.presenceControl.model.embeddedID.TransitionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransitionRepository extends JpaRepository<Transition, TransitionId> {
}
