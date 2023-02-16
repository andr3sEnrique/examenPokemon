package mx.edu.utez.examen.models.entrenador;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {
    Optional<Entrenador> findById(Long id);
    Optional<Entrenador> findByName(String name);

}
