package com.dio.presenceControl.model;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
public class CompTime {

    @Getter
    @Setter
    @EqualsAndHashCode
    @Embeddable
    public class  CompTimeId implements Serializable {
        private long idCompTime;
        private long idTransition;
        private long idUser;
    }

    @EmbeddedId
    private CompTimeId id;

    private LocalDateTime workDate;
    private BigDecimal workHours;
    private BigDecimal balance;
}
