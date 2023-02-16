package mx.edu.utez.examen.controllers.entrenador;

import mx.edu.utez.examen.controllers.entrenador.dtos.EntrenadorDto;
import mx.edu.utez.examen.models.entrenador.Entrenador;
import mx.edu.utez.examen.services.entrenador.EntrenadorService;
import mx.edu.utez.examen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-pokedex/entrenador")
@CrossOrigin(origins = {"*"})
public class EntrenadorController {
    @Autowired
    private EntrenadorService service;
    @GetMapping("/")
    public ResponseEntity<Response<List<Entrenador>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Entrenador>> findOne(@PathVariable Long id){
        return new ResponseEntity<>(
                this.service.getOne(id), HttpStatus.OK
        );
    }
    @PostMapping("/")
    public ResponseEntity<Response<Entrenador>> insert(@RequestBody EntrenadorDto entrenadorDto){
        return new ResponseEntity<>(
                this.service.insert(entrenadorDto.getEntrenador()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Response<Entrenador>> update(@RequestBody EntrenadorDto entrenadorDto){
        return new ResponseEntity<>(
                this.service.update(entrenadorDto.getEntrenador()), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Entrenador>> delete(@PathVariable Long id){
        return new ResponseEntity<>(
                this.service.delete(id), HttpStatus.OK
        );
    }
}
