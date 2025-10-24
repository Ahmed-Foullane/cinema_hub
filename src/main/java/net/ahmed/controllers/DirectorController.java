package net.ahmed.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import net.ahmed.DTO.responseDto.FilmResponseDto;
import net.ahmed.entity.Film;
import net.ahmed.mapper.DirectorMapper;
import net.ahmed.mapper.FilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import net.ahmed.DTO.DirectorDTO;
import net.ahmed.entity.Director;
import net.ahmed.service.director.IDirectorService;
import net.ahmed.utils.Validation;

@RestController
@RequestMapping("/api/directors")
public class DirectorController {

    @Autowired
    private IDirectorService directorService;

    @GetMapping
    public ResponseEntity<List<DirectorDTO>> getDirectors() {
        List<Director> directors = directorService.getAllDirectors();
        List<DirectorDTO> directorDTOs = directors.stream()
                .map(DirectorMapper::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(directorDTOs);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getDirectorById(@PathVariable("id") Long id) {
        Director director = directorService.getDirectorById(id);
        DirectorDTO directorDTO = DirectorMapper.fromEntity(director);
        return ResponseEntity.ok(directorDTO);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createDirector(@Valid @RequestBody DirectorDTO directorDTO, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(Validation.getValidationErrors(result));
        }
        return ResponseEntity.ok(directorService.createDirector(directorDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDirector(@PathVariable("id") Long id,
                                            @Valid @RequestBody DirectorDTO directorDTO,
                                            BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(Validation.getValidationErrors(result));
        }
        return ResponseEntity.ok(directorService.updateDirector(id, directorDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDirector(@PathVariable("id") Long id) {
        directorService.deleteDirector(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Director deleted successfully");
        response.put("id", id.toString());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<DirectorDTO>> filterByLessThenDate(@RequestParam("nom") String nom){
        List<Director> directors = directorService.searchByLastname(nom);
        List<DirectorDTO> directorDTOList = directors.stream().map(DirectorMapper::fromEntity).toList();
        return ResponseEntity.ok(directorDTOList);
    }

}
