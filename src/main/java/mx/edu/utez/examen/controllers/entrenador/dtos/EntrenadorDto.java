package mx.edu.utez.examen.controllers.entrenador.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.examen.models.entrenador.Entrenador;
import mx.edu.utez.examen.models.pokemon.Pokemon;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EntrenadorDto {
    private Long id;
    private String name;
    private String teamName;
    private List<Pokemon> pokemons;
    public Entrenador getEntrenador(){
        return new Entrenador(
                getId(),
                getName(),
                getTeamName(),
                getPokemons()

        );
    }
}
