package innovar.io.demo1.service;

import innovar.io.demo1.dao.PersonaDao;
import innovar.io.demo1.exception.ResourceNotFoundException;
import innovar.io.demo1.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonaService {
    //personasql
    @Autowired
    PersonaDao personaDao;


    public Persona buscarPorId(String id) {
        Persona pe = personaDao.findById(id);
        if(pe == null){
            try {
                throw new  ResourceNotFoundException("Persona no encontrada con el id ::"+id);
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        return pe;
    }


    public List<Persona> listar() {
        return personaDao.findAll();
    }

    public Persona crear(Persona persona) {
        return personaDao.save(persona);
    }

    public Persona actualizar(String id ,Persona atributosPersona) {
        Persona personaA = buscarPorId(id);

        personaA.setApellidoMaterno(atributosPersona.getApellidoMaterno());
        personaA.setApellidoPaterno(atributosPersona.getApellidoPaterno());
        personaA.setDocIdentidad(atributosPersona.getDocIdentidad());
        personaA.setTipoDocIdentidad(atributosPersona.getTipoDocIdentidad());
        personaA.setEdad(atributosPersona.getEdad());
        personaA.setSexo(atributosPersona.getSexo());
        personaA.setFechaNac(atributosPersona.getFechaNac());
        personaA.setNombre(atributosPersona.getNombre());
        personaA.setOcupacion(atributosPersona.getOcupacion());

        final Persona personaActualizada = personaDao.save(personaA);
        return personaActualizada;
    }



    public Map<String, Boolean> borrar(String Id) {
        Persona persona = buscarPorId(Id);
        personaDao.delete(Id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
