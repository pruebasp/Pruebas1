package innovar.io.demo1.dao;

import innovar.io.demo1.dao.mongoconfig.IPersonaRepositoryMongo;
import innovar.io.demo1.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaRepositoryMongo implements PersonaDao {
    @Autowired
    IPersonaRepositoryMongo iPersonaRepositoryMongo;


    @Override
    public Persona findById(String id) {


        Optional<Persona> p = iPersonaRepositoryMongo.findById(id);
        if (p.isPresent()) {
            return p.get();
        }
        else{
            return null;
        }

    }

    @Override
    public List<Persona> findAll() {
        return iPersonaRepositoryMongo.findAll();
    }

    @Override
    public Persona save(Persona persona) {
        return iPersonaRepositoryMongo.save(persona);
    }

    @Override
    public boolean delete(String id) {
        iPersonaRepositoryMongo.deleteById(id);
        return false;
    }
}
