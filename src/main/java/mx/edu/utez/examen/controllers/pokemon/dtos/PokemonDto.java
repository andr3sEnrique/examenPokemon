package mx.edu.utez.examen.controllers.pokemon.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.examen.models.entrenador.Entrenador;
import mx.edu.utez.examen.models.pokemon.Pokemon;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PokemonDto {
    private Long id;
    private String name;
    private String type;
    private Long power;
    private Long health;
    private Long attack;
    private Long shield;
    private Entrenador entrenador;
    public Pokemon getPokemon(){
        return new Pokemon(
                getId(),
                getName(),
                getType(),
                getPower(),
                getHealth(),
                getAttack(),
                getShield(),
                getEntrenador()
        );
    }
}
