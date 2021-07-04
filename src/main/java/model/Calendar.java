package model;

import lombok.*;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Calendar {
    private Long id;

    @ManyToOne
    private DataType dataType;
    private String description;
    private LocalDateTime especialDate;

}
