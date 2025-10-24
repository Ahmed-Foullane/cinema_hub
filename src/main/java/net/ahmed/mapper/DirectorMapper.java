package net.ahmed.mapper;

import net.ahmed.DTO.DirectorDTO;
import net.ahmed.entity.Director;

import java.util.stream.Collectors;

public class DirectorMapper {
    public static Director toEntity(DirectorDTO dto){
        Director director = new Director();
        director.setBiography(dto.getBiography());
        director.setBirthDate(dto.getBirthDate());
        director.setFirstName(dto.getFirstName());
        director.setLastName(dto.getLastName());
        director.setNationality(dto.getNationality());
        return director;
    }

    public static DirectorDTO fromEntity(Director director) {
        DirectorDTO dto = new DirectorDTO();
        dto.setBiography(director.getBiography());
        dto.setBirthDate(director.getBirthDate());
        dto.setFirstName(director.getFirstName());
        dto.setLastName(director.getLastName());
        dto.setNationality(director.getNationality());
        if (director.getFilms() != null) {
            dto.setFilms(
                    director.getFilms().stream()
                            .map(FilmMapper::fromEntity)
                            .collect(Collectors.toList())
            );
        }
        return dto;
    }
}