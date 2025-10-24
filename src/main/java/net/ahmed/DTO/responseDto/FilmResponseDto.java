package net.ahmed.DTO.responseDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class FilmResponseDto {
    private Integer durationInMinut;
    private Integer ratingOutOfTeen;
    private String synopsis;
    private String title;
    private String categoryName;
    private LocalDate releaseDate;
    public FilmResponseDto(){}
}
