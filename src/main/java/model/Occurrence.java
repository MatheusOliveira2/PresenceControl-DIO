package model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Occurrence {
    private Long id;
    private String name;
    private String description;

}
