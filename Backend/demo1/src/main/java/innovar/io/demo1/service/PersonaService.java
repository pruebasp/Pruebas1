package innovar.io.demo1.service;

import innovar.io.demo1.dao.PersonaDao;
import innovar.io.demo1.exception.ResourceNotFoundException;
import innovar.io.demo1.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    @Autowired
    PersonaDao personaDao;


    public Persona buscarPorId(String id) throws ResourceNotFoundException {
        Persona pe = personaDao.findById(id);
        if(pe == null){

            throw new  ResourceNotFoundException("Persona no encontrada con el id ::"+id);

        }
        return pe;
    }


    public List<Persona> listar() {
        return personaDao.findAll();
    }

    public Persona crear(Persona persona) {
        return personaDao.save(persona);
    }

    public Persona actualizar(String id ,Persona atributosPersona) throws ResourceNotFoundException {
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



    public boolean borrar(String id) throws ResourceNotFoundException {

        Persona persona = buscarPorId(id);
        if(persona == null){
            return false;
        }

        try {
            personaDao.delete(id);
            return true;

        }catch (Exception e ){
            return false;
        }



    }
}
