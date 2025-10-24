package net.ahmed.mapper;

import net.ahmed.DTO.FilmDTO;
import net.ahmed.DTO.responseDto.FilmResponseDto;
import net.ahmed.entity.Category;
import net.ahmed.entity.Director;
import net.ahmed.entity.Film;

public class FilmMapper {

    public static Film toEntity(FilmDTO dto, Category category, Director director) {
        Film film = new Film();
        film.setTitle(dto.getTitle());
        film.setDurationMinutes(dto.getDurationInMinut());
        film.setRating(dto.getRatingOutOfTeen());
        film.setSynopsis(dto.getSynopsis());
        film.setCategory(category);
        film.setDirector(director);
        film.setReleaseDate(dto.getReleaseDate());
        return film;
    }

    public static FilmResponseDto fromEntity(Film film){
        FilmResponseDto filmDTO = new FilmResponseDto();
        filmDTO.setTitle(film.getTitle());
        filmDTO.setSynopsis(film.getSynopsis());
        filmDTO.setDurationInMinut(film.getDurationMinutes());
        filmDTO.setRatingOutOfTeen(film.getRating());
        filmDTO.setReleaseDate(film.getReleaseDate());
        if (film.getCategory()!=null){
          filmDTO.setCategoryName(film.getCategory().getName());
        }
        return filmDTO;
    }



}
