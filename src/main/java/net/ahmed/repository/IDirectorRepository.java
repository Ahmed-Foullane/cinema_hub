package net.ahmed.repository;

import net.ahmed.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDirectorRepository extends JpaRepository<Director, Long> {
    List<Director> findByLastNameContainingIgnoreCase(String lastName);
}
