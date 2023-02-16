package mx.edu.utez.examen.services.entrenador;

import mx.edu.utez.examen.models.entrenador.Entrenador;
import mx.edu.utez.examen.models.entrenador.EntrenadorRepository;
import mx.edu.utez.examen.models.pokemon.Pokemon;
import mx.edu.utez.examen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EntrenadorService {
    @Autowired
    private EntrenadorRepository repository;
    @Transactional(readOnly = true)
    public Response<List<Entrenador>> getAll(){
        return new Response<>(
                this.repository.findAll(), false, 200, "OK"
        );
    }
    @Transactional(readOnly = true)
    public Response<Entrenador> getOne (Long id){
        if (this.repository.existsById(id)){
            return new Response<>(
                this.repository.findById(id).get(), false, 200, "OK");
        }
        return new Response<>(
                null, true, 400, "No se encontró al entrenador"
        );
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Entrenador> insert(Entrenador entrenador){
        Optional<Entrenador> exists = this.repository.findByName(entrenador.getName());
        if (exists.isPresent())
            return new Response<>(
                    null,
                    true,
                    400,
                    "El entrenador ya se encuentra regisrada");
        return new Response<>(
                this.repository.saveAndFlush(entrenador),
                false,
                200,
                "Entrenador registrado correctamente"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Entrenador> update(Entrenador entrenador){
        if (!this.repository.existsById(entrenador.getId()))
            return new Response<>(
                    null,
                    true,
                    400,
                    "El entrenador no se encontró");
        return new Response<>(
                this.repository.saveAndFlush(entrenador),
                false,
                200,
                "Entrenador actualizado correctamente");
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Entrenador> delete(Long id){
        Response response = null;
        if (this.repository.existsById(id)){
            this.repository.deleteById(id);
            response = new Response<>(
                    this.repository.findById(id),
                    false,
                    200,
                    "entrenador eliminado correctamente");
        }else{
            response = new Response<>(
                    null,
                    true,
                    400,
                    "El entrenador no se encontró");
        }

        return response;
    }
}
