package net.ahmed.service.director;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ahmed.DTO.DirectorDTO;
import net.ahmed.entity.Director;
import net.ahmed.mapper.DirectorMapper;
import net.ahmed.repository.IDirectorRepository;

@Service
public class DirectorServiceImpl implements IDirectorService {

    @Autowired
    private IDirectorRepository directorRepository;

    @Override
    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    @Override
    public Director getDirectorById(Long id) {
        return directorRepository.findById(id).orElseThrow(() -> new RuntimeException("the director id not found: " + id));
    }

    @Override
    public Director createDirector(DirectorDTO directorDTO) {
        Director director = DirectorMapper.toEntity(directorDTO);
        return directorRepository.save(director);
    }

    @Override
    public Director updateDirector(Long id, DirectorDTO directorDTO) {
        Director director = getDirectorById(id);
        director.setBiography(directorDTO.getBiography());
        director.setBirthDate(directorDTO.getBirthDate());
        director.setFirstName(directorDTO.getFirstName());
        director.setLastName(directorDTO.getLastName());
        director.setNationality(directorDTO.getNationality());
        return directorRepository.save(director);
    }

    @Override
    public void deleteDirector(Long id) {
        Director director = getDirectorById(id);
        directorRepository.delete(director);
    }

    @Override
    public List<Director> searchByLastname(String lastName) {
        return directorRepository.findByLastNameContainingIgnoreCase(lastName);
    }
}
