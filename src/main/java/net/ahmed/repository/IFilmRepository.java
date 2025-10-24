package net.ahmed.repository;

import net.ahmed.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IFilmRepository extends JpaRepository<Film, Long> {
    List<Film> findByTitleContainingIgnoreCase(String title);
    List<Film> findByRatingLessThanEqual(Double rating);
    List<Film> findByRatingGreaterThanEqual(Double rating);
    List<Film> findByReleaseDateGreaterThanEqual(LocalDate releaseDate);
    List<Film> findByReleaseDateLessThanEqual(LocalDate releaseDate);
}