package model;


import lombok.*;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class User {
    private Long id;

    @ManyToOne
    private UserCategory userCategory;
    private String name;

    @ManyToOne
    private Company company;

    @ManyToOne
    private AccessLevel accessLevel;

    @ManyToOne
    private WorkingDay workingDay;
    private BigDecimal tolerance;
    private LocalDateTime journeyStart;
    private LocalDateTime journeyEnd;
}
