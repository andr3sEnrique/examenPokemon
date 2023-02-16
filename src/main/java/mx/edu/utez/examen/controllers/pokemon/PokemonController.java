package mx.edu.utez.examen.controllers.pokemon;

import mx.edu.utez.examen.controllers.entrenador.dtos.EntrenadorDto;
import mx.edu.utez.examen.controllers.pokemon.dtos.PokemonDto;
import mx.edu.utez.examen.models.entrenador.Entrenador;
import mx.edu.utez.examen.models.pokemon.Pokemon;
import mx.edu.utez.examen.services.pokemon.PokemonService;
import mx.edu.utez.examen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-pokedex/pokemon")
@CrossOrigin(origins = {"*"})
public class PokemonController {
    @Autowired
    private PokemonService service;
    @GetMapping("/")
    public ResponseEntity<Response<List<Pokemon>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(), HttpStatus.OK
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response<Pokemon>> findOne(@PathVariable Long id){
        return new ResponseEntity<>(
                this.service.getOne(id), HttpStatus.OK
        );
    }
    @PostMapping("/")
    public ResponseEntity<Response<Pokemon>> insert(@RequestBody PokemonDto pokemonDto){
        return new ResponseEntity<>(
                this.service.insert(pokemonDto.getPokemon()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Response<Pokemon>> update(@RequestBody PokemonDto pokemonDto){
        return new ResponseEntity<>(
                this.service.update(pokemonDto.getPokemon()), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Pokemon>> delete(@PathVariable Long id){
        return new ResponseEntity<>(
                this.service.delete(id), HttpStatus.OK
        );
    }
}
