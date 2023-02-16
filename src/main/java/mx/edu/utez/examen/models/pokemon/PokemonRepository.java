package mx.edu.utez.examen.models.pokemon;

import mx.edu.utez.examen.models.entrenador.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Optional<Pokemon> findById(Long id);
    Optional<Pokemon> findByName(String name);

}
