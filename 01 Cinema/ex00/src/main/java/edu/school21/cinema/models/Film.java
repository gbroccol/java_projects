package edu.school21.cinema.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Film {
    private Long        filmId;
    private String      title;
    private String      releaseYear;
    private String      ageRestrictions;
    private String      description;
}
