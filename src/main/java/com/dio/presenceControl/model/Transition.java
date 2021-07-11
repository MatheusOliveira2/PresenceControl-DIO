package com.dio.presenceControl.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Transition {

    @Id
    @EmbeddedId
    private TransitionId id;
    private LocalDateTime inputDate;
    private LocalDateTime outputDate;
    private BigDecimal period;

    @ManyToOne
    private Occurrence occurrence;

    @ManyToOne
    private Calendar calendar;
}

