package net.ahmed.service.film;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ahmed.DTO.FilmDTO;
import net.ahmed.entity.Category;
import net.ahmed.entity.Director;
import net.ahmed.entity.Film;
import net.ahmed.mapper.FilmMapper;
import net.ahmed.repository.IFilmRepository;
import net.ahmed.service.category.ICategoryService;
import net.ahmed.service.director.IDirectorService;

@Service
public class FilmServiceImpl implements IFilmService{

    @Autowired
    private IFilmRepository filmRepository;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IDirectorService directorService;

    @Override
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public Film getFilmById(Long id) {
        return filmRepository.findById(id).orElseThrow(() -> new RuntimeException("the film id not found: " + id));
    }

    @Override
    public Film createFilm(FilmDTO filmDTO) {
        Category category = categoryService.getCategoryById(filmDTO.getCategoryId());
        Director director = directorService.getDirectorById(filmDTO.getDirectorId());
        Film film = FilmMapper.toEntity(filmDTO, category, director);
        return filmRepository.save(film);
    }

    @Override
    public Film updateFilm(Long id, FilmDTO filmDTO) {
        Film film = getFilmById(id);
        Category category = categoryService.getCategoryById(filmDTO.getCategoryId());
        Director director = directorService.getDirectorById(filmDTO.getDirectorId());
        
        film.setTitle(filmDTO.getTitle());
        film.setDurationMinutes(filmDTO.getDurationInMinut());
        film.setRating(filmDTO.getRatingOutOfTeen());
        film.setSynopsis(filmDTO.getSynopsis());
        film.setCategory(category);
        film.setDirector(director);
        
        return filmRepository.save(film);
    }

    @Override
    public void deleteFilm(Long id) {
        Film film = getFilmById(id);
        filmRepository.delete(film);
    }

    @Override
    public List<Film> searchByTitle(String title) {
        return filmRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Film> getFilmLessThenRating(Double rating) {
        return filmRepository.findByRatingLessThanEqual(rating);
    }

    @Override
    public List<Film> getFilmGreaterThenRating(Double rating) {
        return filmRepository.findByRatingGreaterThanEqual(rating);
    }

    @Override
    public List<Film> findFilmRelasedAfterDate(LocalDate date) {
        return filmRepository.findByReleaseDateGreaterThanEqual(date);
    }

    @Override
    public List<Film> fiondFilmRelasedBeforeDate(LocalDate date) {
        return filmRepository.findByReleaseDateLessThanEqual(date);
    }
}
