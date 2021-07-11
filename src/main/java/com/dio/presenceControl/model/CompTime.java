package com.dio.presenceControl.model;

import com.dio.presenceControl.model.embeddedID.CompTimeId;
import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    @EmbeddedId
    private CompTimeId id;

    private LocalDateTime workDate;
    private BigDecimal workHours;
    private BigDecimal balance;
}

