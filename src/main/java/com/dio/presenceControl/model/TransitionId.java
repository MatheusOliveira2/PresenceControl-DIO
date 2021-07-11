package com.dio.presenceControl.model;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Embeddable
public class TransitionId implements Serializable {
    private long idTransition;
    private long idUser;
}
