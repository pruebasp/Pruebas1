package innovar.io.demo1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import innovar.io.demo1.exception.ResourceNotFoundException;
import innovar.io.demo1.model.Persona;
import innovar.io.demo1.repository.PersonaRepository;

@RestController
@RequestMapping("/api")
public class PersonaController {
    @Autowired
    private PersonaRepository personaRepository;

    //Mostrar la lista de personas
    @GetMapping("/persona/listar")
    public List<Persona> listarPersonas(){
        return personaRepository.findAll();
    }
    @GetMapping("/persona/buscar/{id}")
    public ResponseEntity<Persona> buscarPersona(@PathVariable(value = "id") Long personaId) throws ResourceNotFoundException{
        Persona persona = personaRepository.findById(personaId).orElseThrow(()-> new ResourceNotFoundException("Persona no encontrada con el id ::"+personaId));
        return ResponseEntity.ok().body(persona);
    }

    @PostMapping("/persona/crear")
    public Persona createPersona(@Valid @RequestBody Persona persona) {
        return personaRepository.save(persona);
    }

    @PutMapping("/persona/actualizar/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable(value = "id") Long personaId,
                                                  @Valid @RequestBody Persona atributosPersona) throws ResourceNotFoundException {
        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada con el id :: " + personaId));

        persona.setApellidoMaterno(atributosPersona.getApellidoMaterno());
        persona.setApellidoPaterno(atributosPersona.getApellidoPaterno());
        persona.setDocIdentidad(atributosPersona.getDocIdentidad());
        persona.setTipoDocIdentidad(atributosPersona.getTipoDocIdentidad());
        persona.setEdad(atributosPersona.getEdad());
        persona.setSexo(atributosPersona.getSexo());
        persona.setFechaNac(atributosPersona.getFechaNac());
        persona.setNombre(atributosPersona.getNombre());
        persona.setOcupacion(atributosPersona.getOcupacion());
        final Persona personaActualizada = personaRepository.save(persona);
        return ResponseEntity.ok(personaActualizada);
    }

    @DeleteMapping("/persona/eliminar/{id}")
    public Map<String, Boolean> eliminarPersona(@PathVariable(value = "id") Long personaId)
            throws ResourceNotFoundException {
        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada con el id :: " + personaId));

        personaRepository.delete(persona);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }



}
