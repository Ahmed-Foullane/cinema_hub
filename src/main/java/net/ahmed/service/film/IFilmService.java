package net.ahmed.service.film;

import net.ahmed.DTO.CategoryDTO;
import net.ahmed.DTO.FilmDTO;
import net.ahmed.entity.Category;
import net.ahmed.entity.Film;

import java.time.LocalDate;
import java.util.List;

public interface IFilmService {
   List<Film> getAllFilms();
   Film getFilmById(Long id);
   Film createFilm(FilmDTO filmDTO);
   Film updateFilm(Long id, FilmDTO filmDTO);
   void deleteFilm(Long id);
   List<Film> searchByTitle(String title);
   List<Film> getFilmLessThenRating(Double rating);
   List<Film> getFilmGreaterThenRating(Double rating);
   List<Film> findFilmRelasedAfterDate(LocalDate date);
   List<Film> fiondFilmRelasedBeforeDate(LocalDate date);
   List<Film> findFilmByCategory(String category);
}
