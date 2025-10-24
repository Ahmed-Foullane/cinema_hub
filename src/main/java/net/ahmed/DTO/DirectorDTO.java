package net.ahmed.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import net.ahmed.DTO.responseDto.FilmResponseDto;
import net.ahmed.entity.Film;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class DirectorDTO {
    @NotEmpty(message = "the first name is required")
    private String firstName;
    @NotEmpty(message = "the last name is required")
    private String lastName;
    @NotNull(message = "the birth date is required")
    private LocalDate birthDate;
    @NotEmpty(message = "the nationality is required")
    private String nationality;
    @NotEmpty(message = "the biography is required")
    private String biography;
    private List<FilmResponseDto> films;
    public DirectorDTO(){}
}