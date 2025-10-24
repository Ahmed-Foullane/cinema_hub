package net.ahmed.DTO;


import lombok.Getter;
import jakarta.validation.constraints.*;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FilmDTO {

    @NotNull(message = "the duration is required")
    private Integer durationInMinut;

    @NotNull(message = "the rating is required")
    private Integer ratingOutOfTeen;

    @NotEmpty(message = "the synopsis is required")
    private String synopsis;

    @NotEmpty(message = "the release date is required")
    private LocalDate releaseDate;

    @NotEmpty(message = "the title is required")
    private String title;

    @NotNull(message = "the category id is required")
    private Long categoryId;

    @NotNull(message = "the director id is required")
    private Long directorId;

    public FilmDTO(){}
}