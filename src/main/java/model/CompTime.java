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
public class CompTime {

    @AllArgsConstructor
    @NoArgsConstructor
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
