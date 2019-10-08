package innovar.io.demo1.controller;

import java.util.List;
import javax.validation.Valid;

import innovar.io.demo1.exception.ResourceNotFoundException;
import innovar.io.demo1.model.PersonaDTO;
import innovar.io.demo1.service.PersonaService;
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

import innovar.io.demo1.model.Persona;

@RestController
@RequestMapping("/api")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    //Mostrar la lista de personas
    @GetMapping("/persona/listar")

    public List<Persona> listarPersonas(){
        return personaService.listar();
    }


    @GetMapping("/persona/buscar/{id}")
    public ResponseEntity<Persona> buscarPersona(@PathVariable(value = "id") String personaId) throws ResourceNotFoundException {
       return ResponseEntity.ok().body(personaService.buscarPorId(personaId));
    }

    @PostMapping("/persona/crear")
    public Persona createPersona(@Valid @RequestBody PersonaDTO personaDTO) {
        Persona p = new Persona(personaDTO);

        return personaService.crear(p);
    }

    @PutMapping("/persona/actualizar/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable(value = "id") String personaId, @Valid @RequestBody PersonaDTO personaDTO) throws ResourceNotFoundException {


        Persona p = new Persona(personaDTO);
        return ResponseEntity.ok(personaService.actualizar(personaId,p));
    }

    @DeleteMapping("/persona/eliminar/{id}")
    public boolean eliminarPersona(@PathVariable(value = "id") String personaId) throws ResourceNotFoundException {

        return personaService.borrar(personaId);
    }



}
