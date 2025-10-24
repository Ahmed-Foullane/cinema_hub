package net.ahmed.DTO;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import net.ahmed.DTO.responseDto.FilmResponseDto;

import java.util.List;

@Getter
@Setter
public class CategoryDTO {
    @NotEmpty(message = "the name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;
    @NotEmpty(message = "the description is required")
    @Size(min = 5, max = 50, message = "description must be between 3 and 50 characters")
    private String description;
    private List<FilmResponseDto> films;
    public CategoryDTO(){}
}