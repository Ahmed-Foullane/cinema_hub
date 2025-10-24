package net.ahmed.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ahmed.DTO.responseDto.FilmResponseDto;
import net.ahmed.mapper.FilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import net.ahmed.DTO.FilmDTO;
import net.ahmed.entity.Film;
import net.ahmed.service.film.IFilmService;
import net.ahmed.utils.Validation;

@RestController
@RequestMapping("/api/films")
public class FilmController {

    @Autowired
    private IFilmService filmService;

    @GetMapping
    public ResponseEntity<List<FilmResponseDto>> getFilms() {
        List<Film> films = filmService.getAllFilms();
        List<FilmResponseDto> filmResponseDtos = films.stream().map(FilmMapper::fromEntity).toList();
        return ResponseEntity.ok(filmResponseDtos);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getFilmById(@PathVariable("id") Long id) {
        Film film = filmService.getFilmById(id);
        FilmResponseDto filmResponseDto = FilmMapper.fromEntity(film);
        return ResponseEntity.ok(filmResponseDto);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createFilm(@Valid @RequestBody FilmDTO filmDTO, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(Validation.getValidationErrors(result));
        }
        Film film = filmService.createFilm(filmDTO);
        FilmResponseDto filmResponseDto = FilmMapper.fromEntity(film);
        return ResponseEntity.ok(filmResponseDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateFilm(@PathVariable("id") Long id,
                                        @Valid @RequestBody FilmDTO filmDTO,
                                        BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(Validation.getValidationErrors(result));
        }
        Film film = filmService.updateFilm(id, filmDTO);
        FilmResponseDto filmResponseDto = FilmMapper.fromEntity(film);
        return ResponseEntity.ok(filmResponseDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFilm(@PathVariable("id") Long id) {
        filmService.deleteFilm(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Film deleted successfully");
        response.put("id", id.toString());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<FilmResponseDto>> searchByName(@RequestParam("title") String title){
        List<Film> films = filmService.searchByTitle(title);
        List<FilmResponseDto> filmResponseDtos = films.stream().map(FilmMapper::fromEntity).toList();
        return ResponseEntity.ok(filmResponseDtos);
    }

    @GetMapping("/filter/rating/less")
    public ResponseEntity<List<FilmResponseDto>> filterByLessThenRating(@RequestParam("rating") Double rating){
        List<Film> films = filmService.getFilmLessThenRating(rating);
        List<FilmResponseDto> filmResponseDtos = films.stream().map(FilmMapper::fromEntity).toList();
        return ResponseEntity.ok(filmResponseDtos);
    }

    @GetMapping("/filter/rating/grater")
    public ResponseEntity<List<FilmResponseDto>> filterByGraterThenRating(@RequestParam("rating") Double rating){
        List<Film> films = filmService.getFilmGreaterThenRating(rating);
        List<FilmResponseDto> filmResponseDtos = films.stream().map(FilmMapper::fromEntity).toList();
        return ResponseEntity.ok(filmResponseDtos);
    }

    @GetMapping("/filter/date/grater")
    public ResponseEntity<List<FilmResponseDto>> filterByGraterThenDate(@RequestParam("date") LocalDate date){
        List<Film> films = filmService.findFilmRelasedAfterDate(date);
        List<FilmResponseDto> filmResponseDtos = films.stream().map(FilmMapper::fromEntity).toList();
        return ResponseEntity.ok(filmResponseDtos);
    }

    @GetMapping("/filter/date/less")
    public ResponseEntity<List<FilmResponseDto>> filterByLessThenDate(@RequestParam("date") LocalDate date){
        List<Film> films = filmService.fiondFilmRelasedBeforeDate(date);
        List<FilmResponseDto> filmResponseDtos = films.stream().map(FilmMapper::fromEntity).toList();
        return ResponseEntity.ok(filmResponseDtos);
    }



}