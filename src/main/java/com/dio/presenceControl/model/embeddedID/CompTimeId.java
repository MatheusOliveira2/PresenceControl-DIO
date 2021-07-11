package com.dio.presenceControl.model.embeddedID;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Embeddable
public class CompTimeId implements Serializable {
    private long idCompTime;
    private long idTransition;
    private long idUser;
}
