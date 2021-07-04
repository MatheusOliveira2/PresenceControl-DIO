package model;


import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Transition {

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class  TransitionId implements Serializable {
        private long idTransition;
        private long idUser;
    }

    @EmbeddedId
    private TransitionId id;
    private LocalDateTime inputDate;
    private LocalDateTime outputDate;
    private BigDecimal period;
    private Occurrence occurrence;
    private Calendar calendar;
}
