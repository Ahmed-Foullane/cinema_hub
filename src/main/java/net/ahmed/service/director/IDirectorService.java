package net.ahmed.service.director;

import java.util.List;

import net.ahmed.DTO.DirectorDTO;
import net.ahmed.entity.Director;

public interface IDirectorService {
    List<Director> getAllDirectors();
    Director getDirectorById(Long id);
    Director createDirector(DirectorDTO directorDTO);
    Director updateDirector(Long id, DirectorDTO directorDTO);
    void deleteDirector(Long id);
    List<Director> searchByLastname(String lastName);
}