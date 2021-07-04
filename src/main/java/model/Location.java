package model;


import lombok.*;

import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Location {
    private Long id;

    @ManyToOne
    private AccessLevel accessLevel;
    private String description;
}
